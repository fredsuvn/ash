package org.volcraft.common.base

import org.volcraft.common.Constant
import org.volcraft.common.base.NamingCase.*

/**
 * Represents a naming case rule such as camel case, underscore case and hyphen case. It includes a [Splitter] to split
 * name into individual words, and a [CaseProcessor] to process case of each individual word, and a [Joiner] to join the
 * individual words into a name.
 */
abstract class NamingCase {
    protected abstract val splitter: Splitter
    protected abstract val caseProcessor: CaseProcessor
    protected abstract val joiner: Joiner
    abstract val name: String

    /**
     * Converts [str] from current case into [target] case.
     */
    open fun to(target: NamingCase, str: String): String {
        return if (this == target) {
            str
        } else {
            splitter.split(str).let {
                it.forEachIndexed { index, word ->
                    it[index] = caseProcessor.process(index, word)
                }
                it
            }.let {
                target.joiner.join(it)
            }
        }
    }

    /**
     * Splitter of [NamingCase] to split name into words by current case rule.
     */
    interface Splitter {

        /**
         * Splits [str] into words by current case rule.
         */
        fun split(str: String): Array<String>
    }

    /**
     * Case processor of [NamingCase] to process case for each word split by [Splitter].
     */
    interface CaseProcessor {

        /**
         * Processes case of [word] of specified [index] split by [Splitter].
         */
        fun process(index: Int, word: String): String
    }

    /**
     * Joiner of [NamingCase] to join words into a name by current case rule.
     */
    interface Joiner {

        /**
         * Joins [words] into a name by current case rule.
         */
        fun join(words: Array<String>): String
    }
}

/**
 * [NamingCase.Splitter] for delimiter case such as underscore case and hyphen case, the delimiter (such as "_" and "-")
 * is specified by [delimiter]
 */
class DelimiterCaseSplitter(private val delimiter: String) : NamingCase.Splitter {
    override fun split(str: String): Array<String> = str.split(delimiter).toTypedArray()
}

/**
 * [NamingCase.CaseProcessor] for no-operation -- just return input word itself.
 */
object NopCaseProcessor : NamingCase.CaseProcessor {
    override fun process(index: Int, word: String): String = word
}

/**
 * [NamingCase.CaseProcessor] for lower case.
 */
object LowerCaseProcessor : NamingCase.CaseProcessor {
    override fun process(index: Int, word: String): String = word.toLowerCase()
}

/**
 * [NamingCase.CaseProcessor] for upper case.
 */
object UpperCaseProcessor : NamingCase.CaseProcessor {
    override fun process(index: Int, word: String): String = word.toUpperCase()
}

/**
 * [NamingCase.Joiner] for join the words processed by [NamingCase.CaseProcessor] with specified [delimiter].
 */
class DelimiterCaseJoiner(private val delimiter: String) : NamingCase.Joiner {
    override fun join(words: Array<String>): String = words.joinToString(separator = delimiter)
}

/**
 * A [DelimiterCaseJoiner] of which delimiter is an empty string.
 */
val EmptyDelimiterCaseJoiner = DelimiterCaseJoiner(Constant.EMPTY_STRING)


// Camel case:

/**
 * [NamingCase.Splitter] for camel case.
 */
object CamelCaseSplitter : NamingCase.Splitter {

    private fun count(str: String): Int {
        if (str.isEmpty()) {
            return 0
        }

        var c = if (str[0].isUpperCase()) 0 else 1
        var i = 0
        loop@ while (i < str.length) {
            if (str[i].isUpperCase()) {
                var upperCounter = 1
                while (++i < str.length && str[i].isUpperCase()) {
                    upperCounter++
                }
                when {
                    upperCounter == 1 -> {
                        c++
                        continue@loop
                    }
                    i >= str.length -> {
                        c++
                        break@loop
                    }
                    else -> {
                        c += 2
                        continue@loop
                    }
                }
            } else {
                i++
            }
        }
        return c
    }

    override fun split(str: String): Array<String> {
        val array = arrayOfNulls<String>(count(str))
        if (array.isEmpty()) {
            return array as Array<String>
        } else if (array.size == 1) {
            array[0] = str
            return array as Array<String>
        }

        var i = 0
        var begin = i
        var index = 0
        loop@ while (i < str.length) {
            if (str[i].isUpperCase()) {
                if (i - begin > 0) {
                    array[index++] = str.substring(begin, i)
                }
                begin = i

                var upperCounter = 1
                while (++i < str.length && str[i].isUpperCase()) {
                    upperCounter++
                }
                when {
                    upperCounter == 1 -> {
                        continue@loop
                    }
                    i >= str.length -> {
                        array[index++] = str.substring(begin, i)
                        begin = str.length
                        break@loop
                    }
                    else -> {
                        array[index++] = str.substring(begin, i - 1)
                        begin = i - 1
                        continue@loop
                    }
                }
            } else {
                i++
            }
        }

        if (str.length - begin > 0) {
            array[index] = str.substring(begin)
        }

        return array as Array<String>
    }
}

/**
 * [NamingCase.CaseProcessor] for lower camel case.
 */
object LowerCamelCaseProcessor : NamingCase.CaseProcessor {
    override fun process(index: Int, word: String): String =
            if (index == 0 && word.length > 1 && word[1].isLowerCase()) word.decapitalize() else word.capitalize()
}

/**
 * [NamingCase.CaseProcessor] for upper camel case.
 */
object UpperCamelCaseProcessor : NamingCase.CaseProcessor {
    override fun process(index: Int, word: String): String = word.capitalize()
}

/**
 * Lower camel case.
 */
object LowerCamel : NamingCase() {
    override val splitter = CamelCaseSplitter
    override val caseProcessor = LowerCamelCaseProcessor
    override val joiner = EmptyDelimiterCaseJoiner
    override val name = "LOWER_CAMEL"
}

/**
 * Upper camel case.
 */
object UpperCamel : NamingCase() {
    override val splitter = CamelCaseSplitter
    override val caseProcessor = UpperCamelCaseProcessor
    override val joiner = EmptyDelimiterCaseJoiner
    override val name = "UPPER_CAMEL"
}


// Underscore case:

private const val UNDERSCORE_DELIMITER = "_"
private val UnderscoreSplitter = DelimiterCaseSplitter(UNDERSCORE_DELIMITER)
private val UnderscoreJoiner = DelimiterCaseJoiner(UNDERSCORE_DELIMITER)

/**
 * Lower underscore case like lower_underscore.
 */
object LowerUnderscoreCase : NamingCase() {
    override val splitter = UnderscoreSplitter
    override val caseProcessor = LowerCaseProcessor
    override val joiner = UnderscoreJoiner
    override val name = "LOWER_UNDERSCORE"
}

/**
 * Upper underscore case like UPPER_UNDERSCORE.
 */
object UpperUnderscoreCase : NamingCase() {
    override val splitter = UnderscoreSplitter
    override val caseProcessor = UpperCaseProcessor
    override val joiner = UnderscoreJoiner
    override val name = "UPPER_UNDERSCORE"
}


// Hyphen case:

private const val HYPHEN_DELIMITER = "-"
private val HyphenSplitter = DelimiterCaseSplitter(HYPHEN_DELIMITER)
private val HyphenJoiner = DelimiterCaseJoiner(HYPHEN_DELIMITER)

/**
 * Lower hyphen case like lower-hyphen.
 */
object LowerHyphenCase : NamingCase() {
    override val splitter = HyphenSplitter
    override val caseProcessor = LowerCaseProcessor
    override val joiner = HyphenJoiner
    override val name = "LOWER_HYPHEN"
}

/**
 * Upper hyphen case like UPPER-HYPHEN.
 */
object UpperHyphenCase : NamingCase() {
    override val splitter = HyphenSplitter
    override val caseProcessor = UpperCaseProcessor
    override val joiner = HyphenJoiner
    override val name = "UPPER_HYPHEN"
}