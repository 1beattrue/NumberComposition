package edu.mirea.onebeattrue.numbercomposition.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize // аннотация вместо реализации методов (для использования - в gradle -> plugins -> id("kotlin-parcelize"))
data class GameSettings(
    val maxSumValue: Int,
    val minCountOfRightAnswers: Int,
    val minPercentOfRightAnswers: Int,
    val gameTimeInSeconds: Int
) : Parcelable