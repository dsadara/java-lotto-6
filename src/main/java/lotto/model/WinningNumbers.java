package lotto.model;

import java.util.List;

public class WinningNumbers {

    private static final String WINNING_NUMBERS_MUST_BE_6 = "당첨 번호는 6개를 입력해 주세요.";
    private static final String WINNING_NUMBER_RANGE_IS_1_TO_45 = "1부터 45까지의 당첨번호를 입력해 주세요.";
    private static final String WINNING_NUMBERS_MUST_BE_DISTINCT = "당첨 번호는 중복이 아니여야 합니다.";
    private static final int BONUS_NUMBER_INDEX = 6;

    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDistinct(numbers);
        numbers.forEach(this::validateRange);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(WINNING_NUMBERS_MUST_BE_6);
        }
    }

    private void validateDistinct(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(WINNING_NUMBERS_MUST_BE_DISTINCT);
        }
    }

    private void validateRange(int number) {
        if (number < 0 || 45 < number) {
            throw new IllegalArgumentException(WINNING_NUMBER_RANGE_IS_1_TO_45);
        }
    }

    public void addBonusNumber(int number) {
        validateRange(number);
        numbers.add(number);
        validateDistinct(numbers);
    }

}
