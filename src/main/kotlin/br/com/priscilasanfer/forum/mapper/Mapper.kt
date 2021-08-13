package br.com.priscilasanfer.forum.mapper

interface Mapper<T, U> {
    fun map(t: T): U
}
