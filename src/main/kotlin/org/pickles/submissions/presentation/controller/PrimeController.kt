package org.pickles.submissions.presentation.controller

import org.pickles.submissions.application.service.CalcPrimeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/prime")
class PrimeController {

    var calcPrimeService: CalcPrimeService

    @Autowired
    constructor(calcPrimeService: CalcPrimeService) {
        this.calcPrimeService = calcPrimeService
    }

    @GetMapping("/{number}")
    @ResponseBody
    fun post(@PathVariable("number") number: Int): String {
        if (number > 1_000_000) return "${number}は現在計算できません。"
        if (calcPrimeService.calc(number)) return "${number}は素数です。"
        return "${number}は素数ではありません。"
    }
}