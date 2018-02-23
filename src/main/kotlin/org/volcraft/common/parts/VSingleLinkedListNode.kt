package org.volcraft.common.parts

class VSingleLinkedListNode<T> {

    var value: T? = null
    var next: VSingleLinkedListNode<T>? = null

    constructor()

    constructor(value: T?) : this(value, null)

    constructor(value: T?, next: VSingleLinkedListNode<T>?) {
        this.value = value
        this.next = next
    }
}