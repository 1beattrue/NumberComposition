package edu.mirea.onebeattrue.numbercomposition.presentation.adapters

import android.content.Context
import android.content.res.ColorStateList
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import edu.mirea.onebeattrue.numbercomposition.R
import edu.mirea.onebeattrue.numbercomposition.domain.entity.GameResult

interface ClickListener {
    // этот интерфейс нужен, потому что если в BindingAdapter закинуть lambda,
    // то будет преобразование (Object) -> ...
    operator fun invoke(option: Int)
}

/** fragment_game_finished */
@BindingAdapter("requiredAnswers")
fun bindRequiredAnswers(textView: TextView, count: Int) {
    textView.text = String.format(
        textView.context.getString(R.string.required_score),
        count
    )
}

@BindingAdapter("requiredPercentage")
fun bindRequiredPercentage(textView: TextView, percentage: Int) {
    textView.text = String.format(
        textView.context.getString(R.string.required_percentage),
        percentage
    )
}

@BindingAdapter("score")
fun bindScore(textView: TextView, score: Int) {
    textView.text = String.format(
        textView.context.getString(R.string.required_percentage),
        score
    )
}

@BindingAdapter("scorePercentage")
fun bindScorePercentage(textView: TextView, gameResult: GameResult) {
    textView.text = String.format(
        textView.context.getString(R.string.score_percentage),
        getPercentOfRightAnswers(gameResult)
    )
}

private fun getPercentOfRightAnswers(gameResult: GameResult): Int = with(gameResult) {
    if (countOfQuestions == 0)
        0
    else
        ((countOfRightAnswers / countOfQuestions.toDouble()) * 100).toInt()
}

@BindingAdapter("resultEmoji")
fun bindResultEmoji(imageView: ImageView, winner: Boolean) {
    imageView.setImageResource(getSmileResId(winner))
}

private fun getSmileResId(winner: Boolean): Int {
    return if (winner)
        R.drawable.ic_smile
    else
        R.drawable.ic_sad
}


/** fragment_game */
@BindingAdapter("enoughCount")
fun bindEnoughCount(textView: TextView, enoughCount: Boolean) {
    textView.setTextColor(getColorByState(textView.context, enoughCount))
}

@BindingAdapter("enoughPercent")
fun bindEnoughPercent(progressBar: ProgressBar, enoughPercent: Boolean) {
    progressBar.progressTintList = ColorStateList.valueOf(
        getColorByState(progressBar.context, enoughPercent)
    )
}

@BindingAdapter("progress")
fun bindProgress(progressBar: ProgressBar, percentOfRightAnswers: Int) {
    progressBar.setProgress(percentOfRightAnswers, true)
}

private fun getColorByState(context: Context, goodState: Boolean): Int {
    val colorResId = if (goodState)
        android.R.color.holo_green_light
    else
        android.R.color.holo_red_light
    return ContextCompat.getColor(context, colorResId)
}

@BindingAdapter("minPercent")
fun bindMinPercent(progressBar: ProgressBar, minPercent: Int) {
    progressBar.secondaryProgress = minPercent
}

@BindingAdapter("numberAsText")
fun bindNumberAsText(textView: TextView, number: Int) {
    textView.text = number.toString()
}

@BindingAdapter("onOptionClickListener")
fun bindOnOptionClickListener(textView: TextView, clickListener: ClickListener) {
    textView.setOnClickListener { clickListener(textView.text.toString().toInt()) }
}