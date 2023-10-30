package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ValidatePlayerInput {
    public void validateContainSpace(String playerInput) {
        if (playerInput.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름 구분은 ','로 하셔야합니다");
        }
    }

    public void validateNotContainCarName(String playerInput){
        String[] splitsPlayerInput = playerInput.split(",", -1);

        for (String carName : splitsPlayerInput) {
            if (carName == "") {
                throw new IllegalArgumentException("레이싱 자동차 이름이 없이, 콤마가 연속으로 입력되었습니다");
            }
        }
    }

    public void validateAlphaCarName(String playerInput) {
        String[] splitsPlayerInput = playerInput.split(",", -1);

        for (String carName : splitsPlayerInput) {
            if (!Pattern.matches("^[a-zA-Z]*$", carName)) {
                throw new IllegalArgumentException("레이싱 자동차 이름은 영어만 허용됩니다");
            }
        }
    }

    public void validateCarNameLength(String playerInput) {
        String[] splitsPlayerInput = playerInput.split(",", -1);

        for (String carName : splitsPlayerInput) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름 길이는 5이하 입니다");
            }
        }
    }

    public void validateDuplicateCarNames(String playerInput) {
        String[] splitsPlayerInput = playerInput.split(",", -1);

        Set<String> dulplicateSet = Arrays.stream(splitsPlayerInput).collect(Collectors.toSet());
        if (dulplicateSet.size() != splitsPlayerInput.length) {
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다");
        }
    }

    public void validatePlayerTryCountInput(String playerInput) {
        List<Character> inputStream = playerInput.chars().mapToObj(c -> (char) c).toList();

        inputStream.forEach(c -> {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자만 입력해주시길 바랍니다");
            }
        });
    }

    public List<String> convertStringToListCarNames(String playerInput) {
        String [] splitsPlayerInput = playerInput.split(",", -1);

        final List<String> convertedValues = Arrays.stream(splitsPlayerInput).toList();
        return convertedValues;
    }
}
