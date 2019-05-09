package org.pickles.submissions.application.service

import org.springframework.stereotype.Service

@Service
class CalcPrimeService {

    var primeList: List<Int>

    constructor() {
        var mutableList = mutableListOf(2)
        for (number in 3..1000) {
            if (mutableList.filter{number % it == 0}.isEmpty()) {
                mutableList.add(number)
            }
        }
        this.primeList = mutableList
    }

    fun calc(target: Int): Boolean {
        if (this.primeList.contains(target)) return true
        return this.primeList.filter{target % it == 0}.isEmpty()
    }

}