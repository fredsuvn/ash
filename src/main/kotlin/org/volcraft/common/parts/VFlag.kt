package org.volcraft.common.parts

class VFlag<T> {

    @Volatile
    private var locked = false

    @Volatile
    var value: T? = null
        get() {
            while (locked) {
            }
            return field
        }
        set(newValue) {
            while (locked) {
            }
            field = newValue
        }

    fun waitFor(value: T) {
        while (this.value != value) {
        }
    }

//    fun waitForAndSet(value: T, newValue: T?) {
//        while (this.value != value) {
//        }
//    }

    fun lock() {
        locked = true
    }

    fun unlock() {
        locked = false
    }
}