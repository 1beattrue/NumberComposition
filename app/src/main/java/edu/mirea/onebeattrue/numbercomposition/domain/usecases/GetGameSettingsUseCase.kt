package edu.mirea.onebeattrue.numbercomposition.domain.usecases

import edu.mirea.onebeattrue.numbercomposition.domain.entity.GameSettings
import edu.mirea.onebeattrue.numbercomposition.domain.entity.Level
import edu.mirea.onebeattrue.numbercomposition.domain.repository.GameRepository

class GetGameSettingsUseCase(
    private val repository: GameRepository
) {
    operator fun invoke(level: Level): GameSettings {
        return repository.getGameSettings(level)
    }
}