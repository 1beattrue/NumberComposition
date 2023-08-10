package edu.mirea.onebeattrue.numbercomposition.domain.usecases

import edu.mirea.onebeattrue.numbercomposition.domain.entity.Question
import edu.mirea.onebeattrue.numbercomposition.domain.repository.GameRepository

class GenerateQuestionUseCase(
    private val repository: GameRepository
) {
    operator fun invoke(maxSumValue: Int): Question { // так как UseCase реализует одну функцию - нет смысла давать отдельное имя методу
        return repository.generateQuestion(maxSumValue, COUNT_OF_OPTIONS)
    }

    private companion object {
        private const val COUNT_OF_OPTIONS = 6
    }
}