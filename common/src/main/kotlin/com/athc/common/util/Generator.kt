package com.athc.common.util

import org.apache.commons.text.CharacterPredicates
import org.apache.commons.text.RandomStringGenerator

/**
 * 随机字符生成器
 * @Use Generator.generatorOfLetterAndDigitAndSymbol().generator()
 */
object Generator {

  fun generatorOfLetterAndDigitAndSymbol(): RandomStringGenerator =
      RandomStringGenerator.Builder()
          .withinRange(33, 126)
          .build()

  fun generatorOfLetterAndDigit(): RandomStringGenerator =
      RandomStringGenerator.Builder()
          .withinRange(33, 126)
          .filteredBy(CharacterPredicates.LETTERS, CharacterPredicates.DIGITS)
          .build()

  fun generatorOfDigit(): RandomStringGenerator =
      RandomStringGenerator.Builder()
          .withinRange(33, 126)
          .filteredBy(CharacterPredicates.DIGITS)
          .build()

}