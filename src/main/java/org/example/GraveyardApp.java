package org.example;

import java.util.Scanner;
import java.io.IOException;

public class GraveyardApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        FlowerSelection flowerSelection = new FlowerSelection();
        CoffinSelection coffinSelection = new CoffinSelection();
        BurialSelection burialSelection = new BurialSelection();
        Farewell farewell = new Farewell();
        DateInput dateInput = new DateInput();
        CorpseInput corpseInput = new CorpseInput();
        GraveDepthInput graveDepthInput = new GraveDepthInput();
        Mourning mourning = new Mourning();
        Resurrection resurrection = new Resurrection();
        PsychicInvitation psychicInvitation = new PsychicInvitation();

        try {
            flowerSelection.selectFlowers(scanner);
            coffinSelection.selectCoffin(scanner);
            burialSelection.selectBurialPlace(scanner);
            farewell.bidFarewell(scanner);
            dateInput.inputDate(scanner);
            corpseInput.inputNumberOfCorpses(scanner);
            graveDepthInput.inputGraveDepth(scanner);
            mourning.mourn(scanner);
            resurrection.resurrect(scanner);
            psychicInvitation.invitePsychic(scanner);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
 class FlowerSelection {
    static Log my_log;

    static {
        try {
            my_log = new Log("FlowerSelection.log");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void selectFlowers(Scanner scanner) {
        my_log.logger.info("selectFlowers method called");

        int choice;
        do {
            System.out.println("Какой букет Вы возьмёте на похороны?:");
            System.out.println("1. Цветы, которые Вы принесли с собой");
            System.out.println("2. Цветы купленные у нас");
            while (!scanner.hasNextInt()) {
                System.out.println("Некорректный ввод. Введите цифру 1 или 2.");
                scanner.next(); // очистка буфера
                my_log.logger.warning("Неправильный ввод, введите число.");
            }
            choice = scanner.nextInt();

            if (choice != 1 && choice != 2) {
                System.out.println("Извините, но такого выбора нет в списке");
                my_log.logger.warning("Неправильный выбор: " + choice);
            }
        } while (choice != 1 && choice != 2);

        if (choice == 1) {
            System.out.println("Вы взяли цветы, которые принесли с собой");
            my_log.logger.info("Пользователь решил принести свои цветы.");
        } else if (choice == 2) {
            System.out.println("Вы приобрели цветы для похорон у нас");
            my_log.logger.info("Пользователь решил купить цветы у нас.");
        }
    }
}

 class CoffinSelection {
    static Log my_log;

    static {
        try {
            my_log = new Log("CoffinSelection.log");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void selectCoffin(Scanner scanner) {
        my_log.logger.info("selectCoffin method called");

        int choice;
        do {
            System.out.println("Выберите гроб: ");
            System.out.println("1. Обычный");
            System.out.println("2. Hello Kitty");
            System.out.println("3. Лучше кремация!");
            while (!scanner.hasNextInt()) {
                System.out.println("Некорректный ввод. Введите цифру 1, 2 или 3.");
                scanner.next(); // очистка буфера
                my_log.logger.warning("Неправильный ввод, введите число.");
            }
            choice = scanner.nextInt();

            if (choice < 1 || choice > 3) {
                System.out.println("Извините, но такого выбора нет в списке");
                my_log.logger.warning("Неправильный ввод: " + choice);
            }
        } while (choice < 1 || choice > 3);

        switch (choice) {
            case 1:
                System.out.println("Вы выбрали обычный гроб");
                my_log.logger.info("Пользоваетль выбрал обычный гроб.");
                break;
            case 2:
                System.out.println("Вы выбрали гроб Hello Kitty");
                my_log.logger.info("Пользователь выбрал гроб Hello Kitty.");
                break;
            case 3:
                System.out.println("Как жестоко... Вы решили кремировать человека");
                my_log.logger.info("Пользователь выбрал кремацию.");
                break;
        }
    }
}

class BurialSelection {
    static Log my_log;

    static {
        try {
            my_log = new Log("BurialSelection.log");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void selectBurialPlace(Scanner scanner) {
        my_log.logger.info("selectBurialPlace method called");

        int choice;
        do {
            System.out.println("Выберите место захоронения: ");
            System.out.println("1. Возле семейного кладбища");
            System.out.println("2. На общем кладбище");
            System.out.println("3. Я же сказал кремация, поэтому заберу собой прах в вазе");
            while (!scanner.hasNextInt()) {
                System.out.println("Некорректный ввод. Введите цифру 1, 2 или 3.");
                scanner.next(); // очистка буфера
                my_log.logger.warning("Неправильный ввод, введите число.");
            }
            choice = scanner.nextInt();

            if (choice < 1 || choice > 3) {
                System.out.println("Извините, но такого выбора нет в списке");
                my_log.logger.warning("Неправильный ввод: " + choice);
            }
        } while (choice < 1 || choice > 3);

        switch (choice) {
            case 1:
                System.out.println("Вы решили похоронить человека возле семейного кладбища");
                my_log.logger.info("Пользователь решил похоронить себя на семейном кладбище.");
                break;
            case 2:
                System.out.println("Вы решили похоронить человека на общем кладбище");
                my_log.logger.info("\n" +
                        "Пользователь решил похоронить себя на общем кладбище.");
                break;
            case 3:
                System.out.println("Вы забрали собой прах покойного");
                my_log.logger.info("\n" +
                        "Пользователь решил сохранить прах.");
                break;
        }
    }
}

 class Farewell {
    static Log my_log;

    static {
        try {
            my_log = new Log("Farewell.log");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void bidFarewell(Scanner scanner) {
        my_log.logger.info("bidFarewell method called");

        int choice;
        do {
            System.out.println("Как Вы будете прощаться с покойником: ");
            System.out.println("1. Скажу добрые слова перед захоронением");
            System.out.println("2. Буду читать молитву");
            System.out.println("3. Скажу, что он так и не вернул мне деньги, которые брал в долг");
            while (!scanner.hasNextInt()) {
                System.out.println("Некорректный ввод. Введите цифру 1, 2 или 3.");
                scanner.next(); // очистка буфера
                my_log.logger.warning("Неправильный ввод, введите число.");
            }
            choice = scanner.nextInt();

            if (choice < 1 || choice > 3) {
                System.out.println("Извините, но такого выбора нет в списке");
                my_log.logger.warning("Неправильный ввод: " + choice);
            }
        } while (choice < 1 || choice > 3);

        switch (choice) {
            case 1:
                System.out.println("Вы сказали добрые слова на последок");
                my_log.logger.info("\n" +
                        "Пользователь решил сказать добрые слова.");
                break;
            case 2:
                System.out.println("Вы прочитали молитву");
                my_log.logger.info("\n" +
                        "Пользователь решил произнести молитву.");
                break;
            case 3:
                System.out.println("Жаль, но деньги Вы уже не получите");
                my_log.logger.info("\n" + "Пользователь решил упомянуть о неоплаченном долге.");
                break;
        }
    }
}

 class DateInput {
    static Log my_log;

    static {
        try {
            my_log = new Log("DateInput.log");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void inputDate(Scanner scanner) {
        my_log.logger.info("inputDate method called");

        scanner.nextLine(); // Clear buffer
        System.out.println("Введите дату (ГГГГ ММ ДД): ");
        String dateString = scanner.nextLine();
        my_log.logger.info("Введенная дата: " + dateString);

        String[] dateParts = dateString.split(" ");
        if (dateParts.length == 3) {
            System.out.println("Вы ввели дату: " + dateParts[0] + " " + dateParts[1] + " " + dateParts[2]);
        } else {
            System.out.println("Некорректный ввод даты. Попробуйте снова.");
            my_log.logger.warning("Неверный ввод даты: " + dateString);
        }
    }
}

 class CorpseInput {
    static Log my_log;

    static {
        try {
            my_log = new Log("CorpseInput.log");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void inputNumberOfCorpses(Scanner scanner) {
        my_log.logger.info("inputNumberOfCorpses method called");

        int numberOfCorpses;
        do {
            System.out.println("Введите количество трупов для хоронения:");
            while (!scanner.hasNextInt()) {
                System.out.println("Некорректный ввод. Введите целое число.");
                scanner.next(); // очистка буфера
                my_log.logger.warning("Неправильный ввод, введите число.");
            }
            numberOfCorpses = scanner.nextInt();

            if (numberOfCorpses <= 0) {
                System.out.println("Некорректный ввод. Введите положительное число.");
                my_log.logger.warning("Неверное количество трупов: " + numberOfCorpses);
            }
        } while (numberOfCorpses <= 0);

        System.out.println("Количество трупов для хоронения: " + numberOfCorpses);
        my_log.logger.info("\n" + "Пользователь ввел количество трупов: " + numberOfCorpses);
    }
}

 class GraveDepthInput {
    static Log my_log;

    static {
        try {
            my_log = new Log("GraveDepthInput.log");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void inputGraveDepth(Scanner scanner) {
        my_log.logger.info("inputGraveDepth method called");

        int depth;
        do {
            System.out.println("Введите глубину могилы в метрах:");
            while (!scanner.hasNextInt()) {
                System.out.println("Некорректный ввод. Введите целое число.");
                scanner.next(); // очистка буфера
                my_log.logger.warning("Неправильный ввод, введите число.");
            }
            depth = scanner.nextInt();

            if (depth <= 0) {
                System.out.println("Некорректный ввод. Введите положительное число.");
                my_log.logger.warning("Неверная глубина могилы: " + depth);
            }
        } while (depth <= 0);

        System.out.println("Глубина могилы составляет " + depth + " метров.");
        my_log.logger.info("Пользователь ввел глубину могилы: " + depth + " метров");
    }
}


 class Mourning {
    static Log my_log;

    static {
        try {
            my_log = new Log("Mourning.log");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void mourn(Scanner scanner) {
        my_log.logger.info("mourn method called");

        scanner.nextLine(); // Clear buffer
        System.out.println("Введите имя ушедшего: ");
        String deceasedName = scanner.nextLine();
        my_log.logger.info("Пользователь ввел имя ушедшего: " + deceasedName);

        System.out.println("Имя ушедшего: " + deceasedName);
    }
}
 class Resurrection {
    static Log my_log;

    static {
        try {
            my_log = new Log("Resurrection.log");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void resurrect(Scanner scanner) {
        my_log.logger.info("resurrect method called");

        scanner.nextLine(); // Clear buffer
        System.out.println("Кого Вы воскресите: ");
        String resurrectedName = scanner.nextLine();
        my_log.logger.info("Пользователь ввел имя воскресшего: " + resurrectedName);

        System.out.println("Имя воскрешенного: " + resurrectedName);
    }
}

 class PsychicInvitation {
    static Log my_log;

    static {
        try {
            my_log = new Log("PsychicInvitation.log");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void invitePsychic(Scanner scanner) {
        my_log.logger.info("invitePsychic method called");

        String answer;
        do {
            System.out.println("Хотите ли вы пригласить экстрасенса (да/нет)? ");
            answer = scanner.nextLine().toLowerCase();

            if (!answer.equals("да") && !answer.equals("нет")) {
                System.out.println("Некорректный ввод. Пожалуйста, ответьте \"да\" или \"нет\".");
                my_log.logger.warning("Неправильный ввод, введите 'да' or 'нет'.");
            }
        } while (!answer.equals("да") && !answer.equals("нет"));

        if (answer.equals("да")) {
            System.out.println("Вы решили пригласить экстрасенса.");
            my_log.logger.info("Пользователь решил пригласить экстрасенса.");
        } else {
            System.out.println("Вы решили не приглашать экстрасенса.");
            my_log.logger.info("Пользователь решил не приглашать экстрасенса.");
        }
    }
}