package by.training.branching.branchingamount.service;

import by.training.branching.branchingamount.bean.Thousand;

public class AmountCommand {
    public String exec(String data) {
        StringBuilder builder = new StringBuilder();
        int number = Integer.parseInt(data);
        switch (data.length()) {
            case 4:
                int thousand = number / 1000;
                Thousand th = switch (thousand) {
                    case 1 -> Thousand.ONE;
                    case 2 -> Thousand.TWO;
                    case 3 -> Thousand.THREE;
                    case 4 -> Thousand.FOUR;
                    case 5 -> Thousand.FIVE;
                    case 6 -> Thousand.SIX;
                    case 7 -> Thousand.SEVEN;
                    case 8 -> Thousand.EIGHT;
                    case 9 -> Thousand.NINE;
                    default -> throw new IllegalArgumentException(
                            "Unexpected value: " + thousand);
                };
                builder.append(th.toString()).append(" ");
            case 3:

            case 2:

            case 1:

                break;
            default:
                throw new IllegalArgumentException("Incorrect data");
        }
        return builder.toString();
    }
}
