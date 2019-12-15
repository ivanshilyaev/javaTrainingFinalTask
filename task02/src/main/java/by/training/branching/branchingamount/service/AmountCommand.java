package by.training.branching.branchingamount.service;

import by.training.branching.branchingamount.bean.*;

public class AmountCommand {
    public String exec(String data) {
        StringBuilder builder = new StringBuilder();
        int number = Integer.parseInt(data);
        Thousand th;
        Hundred hun;
        Dozen doz;
        Unit un;
        switch (data.length()) {
            case 4:
                int thousand = number / 1000;
                number %= 1000;
                th = switch (thousand) {
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
                int hundred = number / 100;
                number %= 100;
                hun = switch (hundred) {
                    case 0 -> Hundred.ZERO;
                    case 1 -> Hundred.ONE;
                    case 2 -> Hundred.TWO;
                    case 3 -> Hundred.THREE;
                    case 4 -> Hundred.FOUR;
                    case 5 -> Hundred.FIVE;
                    case 6 -> Hundred.SIX;
                    case 7 -> Hundred.SEVEN;
                    case 8 -> Hundred.EIGHT;
                    case 9 -> Hundred.NINE;
                    default -> throw new IllegalArgumentException(
                            "Unexpected value: " + hundred);
                };
                builder.append(hun.toString());
                if (hun != Hundred.ZERO)
                    builder.append(" ");
            case 2:
                int dozen = number / 10;
                doz = switch (dozen) {
                    case 0 -> Dozen.ZERO;
                    case 1 -> Dozen.ONE;
                    case 2 -> Dozen.TWO;
                    case 3 -> Dozen.THREE;
                    case 4 -> Dozen.FOUR;
                    case 5 -> Dozen.FIVE;
                    case 6 -> Dozen.SIX;
                    case 7 -> Dozen.SEVEN;
                    case 8 -> Dozen.EIGHT;
                    case 9 -> Dozen.NINE;
                    default -> throw new IllegalArgumentException(
                            "Unexpected value: " + dozen);
                };
                if (doz == Dozen.ONE) {
                    TenToNineteen el = switch (number) {
                        case 10 -> TenToNineteen.ZERO;
                        case 11 -> TenToNineteen.ONE;
                        case 12 -> TenToNineteen.TWO;
                        case 13 -> TenToNineteen.THREE;
                        case 14 -> TenToNineteen.FOUR;
                        case 15 -> TenToNineteen.FIVE;
                        case 16 -> TenToNineteen.SIX;
                        case 17 -> TenToNineteen.SEVEN;
                        case 18 -> TenToNineteen.EIGHT;
                        case 19 -> TenToNineteen.NINE;
                        default -> throw new IllegalArgumentException(
                                "Unexpected value: " + number);
                    };
                    builder.append(el.toString());
                    break;
                }
                builder.append(doz.toString());
                if (doz != Dozen.ZERO) {
                    builder.append(" ");
                }
                number %= 10;
            case 1:
                un = switch (number) {
                    case 0 -> Unit.ZERO;
                    case 1 -> Unit.ONE;
                    case 2 -> Unit.TWO;
                    case 3 -> Unit.THREE;
                    case 4 -> Unit.FOUR;
                    case 5 -> Unit.FIVE;
                    case 6 -> Unit.SIX;
                    case 7 -> Unit.SEVEN;
                    case 8 -> Unit.EIGHT;
                    case 9 -> Unit.NINE;
                    default -> throw new IllegalArgumentException(
                            "Unexpected value: " + number);
                };
                builder.append(un.toString());
                break;
            default:
                throw new IllegalArgumentException("Incorrect data");
        }
        return builder.toString();
    }
}
