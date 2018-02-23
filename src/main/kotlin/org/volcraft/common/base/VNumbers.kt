@file:JvmName("VNumbers")
package org.volcraft.common.base

import java.math.BigDecimal
import java.math.BigInteger

//Number
inline fun Number.toBigInteger(): BigInteger = this as? BigInteger ?: BigInteger.valueOf(toLong())
inline fun Number.toBigDecimal(): BigDecimal = this as? BigDecimal ?: BigDecimal(toInt())

//Byte
inline fun Byte.toBigInteger(): BigInteger = BigInteger.valueOf(toLong())
inline fun Byte.toBigDecimal(): BigDecimal = BigDecimal(toInt())

operator fun Byte.compareTo(other: BigInteger): Int = toBigInteger().compareTo(other)
operator fun Byte.compareTo(other: BigDecimal): Int = toBigDecimal().compareTo(other)
operator fun Byte.plus(other: BigInteger): BigInteger = toBigInteger().plus(other)
operator fun Byte.plus(other: BigDecimal): BigDecimal = toBigDecimal().plus(other)
operator fun Byte.minus(other: BigInteger): BigInteger = toBigInteger().minus(other)
operator fun Byte.minus(other: BigDecimal): BigDecimal = toBigDecimal().minus(other)
operator fun Byte.times(other: BigInteger): BigInteger = toBigInteger().times(other)
operator fun Byte.times(other: BigDecimal): BigDecimal = toBigDecimal().times(other)
operator fun Byte.div(other: BigInteger): BigInteger = toBigInteger().div(other)
operator fun Byte.div(other: BigDecimal): BigDecimal = toBigDecimal().div(other)
operator fun Byte.rem(other: BigInteger): BigInteger = toBigInteger().rem(other)
operator fun Byte.rem(other: BigDecimal): BigDecimal = toBigDecimal().rem(other)

//Short
inline fun Short.toBigInteger(): BigInteger = BigInteger.valueOf(toLong())
inline fun Short.toBigDecimal(): BigDecimal = BigDecimal(toInt())

operator fun Short.compareTo(other: BigInteger): Int = toBigInteger().compareTo(other)
operator fun Short.compareTo(other: BigDecimal): Int = toBigDecimal().compareTo(other)
operator fun Short.plus(other: BigInteger): BigInteger = toBigInteger().plus(other)
operator fun Short.plus(other: BigDecimal): BigDecimal = toBigDecimal().plus(other)
operator fun Short.minus(other: BigInteger): BigInteger = toBigInteger().minus(other)
operator fun Short.minus(other: BigDecimal): BigDecimal = toBigDecimal().minus(other)
operator fun Short.times(other: BigInteger): BigInteger = toBigInteger().times(other)
operator fun Short.times(other: BigDecimal): BigDecimal = toBigDecimal().times(other)
operator fun Short.div(other: BigInteger): BigInteger = toBigInteger().div(other)
operator fun Short.div(other: BigDecimal): BigDecimal = toBigDecimal().div(other)
operator fun Short.rem(other: BigInteger): BigInteger = toBigInteger().rem(other)
operator fun Short.rem(other: BigDecimal): BigDecimal = toBigDecimal().rem(other)

//Int
operator fun Int.compareTo(other: BigInteger): Int = toBigInteger().compareTo(other)
operator fun Int.compareTo(other: BigDecimal): Int = toBigDecimal().compareTo(other)
operator fun Int.plus(other: BigInteger): BigInteger = toBigInteger().plus(other)
operator fun Int.plus(other: BigDecimal): BigDecimal = toBigDecimal().plus(other)
operator fun Int.minus(other: BigInteger): BigInteger = toBigInteger().minus(other)
operator fun Int.minus(other: BigDecimal): BigDecimal = toBigDecimal().minus(other)
operator fun Int.times(other: BigInteger): BigInteger = toBigInteger().times(other)
operator fun Int.times(other: BigDecimal): BigDecimal = toBigDecimal().times(other)
operator fun Int.div(other: BigInteger): BigInteger = toBigInteger().div(other)
operator fun Int.div(other: BigDecimal): BigDecimal = toBigDecimal().div(other)
operator fun Int.rem(other: BigInteger): BigInteger = toBigInteger().rem(other)
operator fun Int.rem(other: BigDecimal): BigDecimal = toBigDecimal().rem(other)

//Long
operator fun Long.compareTo(other: BigInteger): Int = toBigInteger().compareTo(other)
operator fun Long.compareTo(other: BigDecimal): Int = toBigDecimal().compareTo(other)
operator fun Long.plus(other: BigInteger): BigInteger = toBigInteger().plus(other)
operator fun Long.plus(other: BigDecimal): BigDecimal = toBigDecimal().plus(other)
operator fun Long.minus(other: BigInteger): BigInteger = toBigInteger().minus(other)
operator fun Long.minus(other: BigDecimal): BigDecimal = toBigDecimal().minus(other)
operator fun Long.times(other: BigInteger): BigInteger = toBigInteger().times(other)
operator fun Long.times(other: BigDecimal): BigDecimal = toBigDecimal().times(other)
operator fun Long.div(other: BigInteger): BigInteger = toBigInteger().div(other)
operator fun Long.div(other: BigDecimal): BigDecimal = toBigDecimal().div(other)
operator fun Long.rem(other: BigInteger): BigInteger = toBigInteger().rem(other)
operator fun Long.rem(other: BigDecimal): BigDecimal = toBigDecimal().rem(other)

//Float
operator fun Float.compareTo(other: BigDecimal): Int = toBigDecimal().compareTo(other)
operator fun Float.plus(other: BigInteger): BigDecimal = toBigDecimal().plus(other.toBigDecimal())
operator fun Float.plus(other: BigDecimal): BigDecimal = toBigDecimal().plus(other)
operator fun Float.minus(other: BigInteger): BigDecimal = toBigDecimal().minus(other.toBigDecimal())
operator fun Float.minus(other: BigDecimal): BigDecimal = toBigDecimal().minus(other)
operator fun Float.times(other: BigInteger): BigDecimal = toBigDecimal().times(other.toBigDecimal())
operator fun Float.times(other: BigDecimal): BigDecimal = toBigDecimal().times(other)
operator fun Float.div(other: BigInteger): BigDecimal = toBigDecimal().div(other.toBigDecimal())
operator fun Float.div(other: BigDecimal): BigDecimal = toBigDecimal().div(other)
operator fun Float.rem(other: BigInteger): BigDecimal = toBigDecimal().rem(other.toBigDecimal())
operator fun Float.rem(other: BigDecimal): BigDecimal = toBigDecimal().rem(other)

//Double
operator fun Double.compareTo(other: BigDecimal): Int = toBigDecimal().compareTo(other)
operator fun Double.plus(other: BigInteger): BigDecimal = toBigDecimal().plus(other.toBigDecimal())
operator fun Double.plus(other: BigDecimal): BigDecimal = toBigDecimal().plus(other)
operator fun Double.minus(other: BigInteger): BigDecimal = toBigDecimal().minus(other.toBigDecimal())
operator fun Double.minus(other: BigDecimal): BigDecimal = toBigDecimal().minus(other)
operator fun Double.times(other: BigInteger): BigDecimal = toBigDecimal().times(other.toBigDecimal())
operator fun Double.times(other: BigDecimal): BigDecimal = toBigDecimal().times(other)
operator fun Double.div(other: BigInteger): BigDecimal = toBigDecimal().div(other.toBigDecimal())
operator fun Double.div(other: BigDecimal): BigDecimal = toBigDecimal().div(other)
operator fun Double.rem(other: BigInteger): BigDecimal = toBigDecimal().rem(other.toBigDecimal())
operator fun Double.rem(other: BigDecimal): BigDecimal = toBigDecimal().rem(other)

//BigInteger
operator fun BigInteger.compareTo(other: Byte): Int = compareTo(other.toBigInteger())
operator fun BigInteger.compareTo(other: Short): Int = compareTo(other.toBigInteger())
operator fun BigInteger.compareTo(other: Int): Int = compareTo(other.toBigInteger())
operator fun BigInteger.compareTo(other: Long): Int = compareTo(other.toBigInteger())
operator fun BigInteger.compareTo(other: Float): Int = toBigDecimal().compareTo(other.toBigDecimal())
operator fun BigInteger.compareTo(other: Double): Int = toBigDecimal().compareTo(other.toBigDecimal())
operator fun BigInteger.compareTo(other: BigDecimal): Int = toBigDecimal().compareTo(other)

operator fun BigInteger.plus(other: Byte): BigInteger = plus(other.toBigInteger())
operator fun BigInteger.plus(other: Short): BigInteger = plus(other.toBigInteger())
operator fun BigInteger.plus(other: Int): BigInteger = plus(other.toBigInteger())
operator fun BigInteger.plus(other: Long): BigInteger = plus(other.toBigInteger())
operator fun BigInteger.plus(other: Float): BigDecimal = toBigDecimal().plus(other.toBigDecimal())
operator fun BigInteger.plus(other: Double): BigDecimal = toBigDecimal().plus(other.toBigDecimal())
operator fun BigInteger.plus(other: BigDecimal): BigDecimal = toBigDecimal().plus(other)

operator fun BigInteger.minus(other: Byte): BigInteger = minus(other.toBigInteger())
operator fun BigInteger.minus(other: Short): BigInteger = minus(other.toBigInteger())
operator fun BigInteger.minus(other: Int): BigInteger = minus(other.toBigInteger())
operator fun BigInteger.minus(other: Long): BigInteger = minus(other.toBigInteger())
operator fun BigInteger.minus(other: Float): BigDecimal = toBigDecimal().minus(other.toBigDecimal())
operator fun BigInteger.minus(other: Double): BigDecimal = toBigDecimal().minus(other.toBigDecimal())
operator fun BigInteger.minus(other: BigDecimal): BigDecimal = toBigDecimal().plus(other)

operator fun BigInteger.times(other: Byte): BigInteger = times(other.toBigInteger())
operator fun BigInteger.times(other: Short): BigInteger = times(other.toBigInteger())
operator fun BigInteger.times(other: Int): BigInteger = times(other.toBigInteger())
operator fun BigInteger.times(other: Long): BigInteger = times(other.toBigInteger())
operator fun BigInteger.times(other: Float): BigDecimal = toBigDecimal().times(other.toBigDecimal())
operator fun BigInteger.times(other: Double): BigDecimal = toBigDecimal().times(other.toBigDecimal())
operator fun BigInteger.times(other: BigDecimal): BigDecimal = toBigDecimal().plus(other)

operator fun BigInteger.div(other: Byte): BigInteger = div(other.toBigInteger())
operator fun BigInteger.div(other: Short): BigInteger = div(other.toBigInteger())
operator fun BigInteger.div(other: Int): BigInteger = div(other.toBigInteger())
operator fun BigInteger.div(other: Long): BigInteger = div(other.toBigInteger())
operator fun BigInteger.div(other: Float): BigDecimal = toBigDecimal().div(other.toBigDecimal())
operator fun BigInteger.div(other: Double): BigDecimal = toBigDecimal().div(other.toBigDecimal())
operator fun BigInteger.div(other: BigDecimal): BigDecimal = toBigDecimal().plus(other)

operator fun BigInteger.rem(other: Byte): BigInteger = rem(other.toBigInteger())
operator fun BigInteger.rem(other: Short): BigInteger = rem(other.toBigInteger())
operator fun BigInteger.rem(other: Int): BigInteger = rem(other.toBigInteger())
operator fun BigInteger.rem(other: Long): BigInteger = rem(other.toBigInteger())
operator fun BigInteger.rem(other: Float): BigDecimal = toBigDecimal().rem(other.toBigDecimal())
operator fun BigInteger.rem(other: Double): BigDecimal = toBigDecimal().rem(other.toBigDecimal())
operator fun BigInteger.rem(other: BigDecimal): BigDecimal = toBigDecimal().plus(other)

//BigDecimal
operator fun BigDecimal.compareTo(other: Byte): Int = compareTo(other.toBigDecimal())
operator fun BigDecimal.compareTo(other: Short): Int = compareTo(other.toBigDecimal())
operator fun BigDecimal.compareTo(other: Int): Int = compareTo(other.toBigDecimal())
operator fun BigDecimal.compareTo(other: Long): Int = compareTo(other.toBigDecimal())
operator fun BigDecimal.compareTo(other: Float): Int = toBigDecimal().compareTo(other.toBigDecimal())
operator fun BigDecimal.compareTo(other: Double): Int = toBigDecimal().compareTo(other.toBigDecimal())
operator fun BigDecimal.compareTo(other: BigInteger): Int = toBigDecimal().compareTo(other.toBigDecimal())

operator fun BigDecimal.plus(other: Byte): BigDecimal = plus(other.toBigDecimal())
operator fun BigDecimal.plus(other: Short): BigDecimal = plus(other.toBigDecimal())
operator fun BigDecimal.plus(other: Int): BigDecimal = plus(other.toBigDecimal())
operator fun BigDecimal.plus(other: Long): BigDecimal = plus(other.toBigDecimal())
operator fun BigDecimal.plus(other: Float): BigDecimal = toBigDecimal().plus(other.toBigDecimal())
operator fun BigDecimal.plus(other: Double): BigDecimal = toBigDecimal().plus(other.toBigDecimal())
operator fun BigDecimal.plus(other: BigInteger): BigDecimal = toBigDecimal().plus(other.toBigDecimal())

operator fun BigDecimal.minus(other: Byte): BigDecimal = minus(other.toBigDecimal())
operator fun BigDecimal.minus(other: Short): BigDecimal = minus(other.toBigDecimal())
operator fun BigDecimal.minus(other: Int): BigDecimal = minus(other.toBigDecimal())
operator fun BigDecimal.minus(other: Long): BigDecimal = minus(other.toBigDecimal())
operator fun BigDecimal.minus(other: Float): BigDecimal = toBigDecimal().minus(other.toBigDecimal())
operator fun BigDecimal.minus(other: Double): BigDecimal = toBigDecimal().minus(other.toBigDecimal())
operator fun BigDecimal.minus(other: BigInteger): BigDecimal = toBigDecimal().plus(other.toBigDecimal())

operator fun BigDecimal.times(other: Byte): BigDecimal = times(other.toBigDecimal())
operator fun BigDecimal.times(other: Short): BigDecimal = times(other.toBigDecimal())
operator fun BigDecimal.times(other: Int): BigDecimal = times(other.toBigDecimal())
operator fun BigDecimal.times(other: Long): BigDecimal = times(other.toBigDecimal())
operator fun BigDecimal.times(other: Float): BigDecimal = toBigDecimal().times(other.toBigDecimal())
operator fun BigDecimal.times(other: Double): BigDecimal = toBigDecimal().times(other.toBigDecimal())
operator fun BigDecimal.times(other: BigInteger): BigDecimal = toBigDecimal().plus(other.toBigDecimal())

operator fun BigDecimal.div(other: Byte): BigDecimal = div(other.toBigDecimal())
operator fun BigDecimal.div(other: Short): BigDecimal = div(other.toBigDecimal())
operator fun BigDecimal.div(other: Int): BigDecimal = div(other.toBigDecimal())
operator fun BigDecimal.div(other: Long): BigDecimal = div(other.toBigDecimal())
operator fun BigDecimal.div(other: Float): BigDecimal = toBigDecimal().div(other.toBigDecimal())
operator fun BigDecimal.div(other: Double): BigDecimal = toBigDecimal().div(other.toBigDecimal())
operator fun BigDecimal.div(other: BigInteger): BigDecimal = toBigDecimal().plus(other.toBigDecimal())

operator fun BigDecimal.rem(other: Byte): BigDecimal = rem(other.toBigDecimal())
operator fun BigDecimal.rem(other: Short): BigDecimal = rem(other.toBigDecimal())
operator fun BigDecimal.rem(other: Int): BigDecimal = rem(other.toBigDecimal())
operator fun BigDecimal.rem(other: Long): BigDecimal = rem(other.toBigDecimal())
operator fun BigDecimal.rem(other: Float): BigDecimal = toBigDecimal().rem(other.toBigDecimal())
operator fun BigDecimal.rem(other: Double): BigDecimal = toBigDecimal().rem(other.toBigDecimal())
operator fun BigDecimal.rem(other: BigInteger): BigDecimal = toBigDecimal().plus(other.toBigDecimal())