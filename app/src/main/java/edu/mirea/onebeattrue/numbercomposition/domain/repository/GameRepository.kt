package edu.mirea.onebeattrue.numbercomposition.domain.repository

import edu.mirea.onebeattrue.numbercomposition.domain.entity.GameSettings
import edu.mirea.onebeattrue.numbercomposition.domain.entity.Level
import edu.mirea.onebeattrue.numbercomposition.domain.entity.Question

interface GameRepository {
    fun generateQuestion(
        maxSumValue: Int,
        countOfOptions: Int
    ): Question
    fun getGameSettings(level: Level): GameSettings
}