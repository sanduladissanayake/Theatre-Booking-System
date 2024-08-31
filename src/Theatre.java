import java.util.*;
import java.io.*;
public class Theatre {
    static Scanner optionInput = new Scanner(System.in);
    static int[] row1= new int[12];
    static int[] row2= new int[16];
    static int[] row3= new int[20];
    static ArrayList <Ticket> buyers = new ArrayList<>();   //array list to save all the tickets

    public static void main(String[] args) {
        System.out.println("Welcome to the New Theatre");

        //setting all the seats to 0
        for (int i = 0;i<row1.length;i++){
            row1[i] = 0;
        }
        for (int i = 0;i<row2.length;i++){
            row2[i] = 0;
        }
        for (int i = 0;i<row3.length;i++){
            row3[i] = 0;
        }
        boolean process = true;
        while(process){
            try {   //printing the Menu
                System.out.println("\n--------------------------------------------------");
                System.out.println("""
                Please select an option :
                1) Buy a ticket
                2) Print seating area
                3) Cancel ticket
                4) List available seats
                5) Save to file
                6) Load from file
                7) Print ticket information and total price
                8) Sort tickets by price
                    0) Quit""");
                System.out.println("--------------------------------------------------");
                System.out.println("\nEnter Option ");

                int menuNumber = optionInput.nextInt();
                switch (menuNumber) {   //use switch case to map user input with correct methods
                    case 1:
                        System.out.println("To buy a ticket;");
                        buy_ticket();
                        break;
                    case 2:
                        System.out.println("Seating Area");
                        print_seating_area();
                        break;
                    case 3:
                        System.out.println("To cancel a ticket;");
                        cancel_ticket();
                        break;
                    case 4:
                        System.out.println("List of available seats");
                        show_available();
                        break;
                    case 5:
                        System.out.println("Saved to file");
                        save();
                        break;
                    case 6:
                        System.out.println("Load from file");
                        load();
                        break;
                    case 7:
                        System.out.println("Tickets Information");
                        show_tickets_info();
                        break;
                    case 8:
                        System.out.println("Tickets are sorted in basis of their prices.");
                        sort_tickets();
                        break;
                    case 0:
                        System.out.println("Thank you,Good bye!");
                        process = false;
                        break;
                    default:
                        System.out.println("invalid input.\nEnter a valid option!");
                        break;
                }
            }catch (Exception e) {
                System.out.println("Invalid input.\nEnter a valid option!");
            }
        }
    }

    private static void buy_ticket() {
        while (true) {
            try {
                Scanner rowInput = new Scanner(System.in);   //getting row number as input
                System.out.println("Enter the row number you need(1-3):");
                int rowNumber = rowInput.nextInt();
                if (rowNumber > 3 || rowNumber < 1) {
                    System.out.println("Enter a valid row number according to the row!");
                    continue;
                }
                while (true) {
                    try {
                        Scanner seatInput = new Scanner(System.in);   //getting seat number as input
                        System.out.println("Enter your seat according to the rows:");
                        int seatNumber = seatInput .nextInt();
                        int[] choseRow;
                        //check validity in row 1
                        if (rowNumber == 1) {
                            choseRow = row1;
                            if (seatNumber < 0 || seatNumber > 13) {
                                System.out.println("Enter a valid seat number!");
                            }
                            if (seatNumber < 13 && seatNumber > 0) {
                                if (choseRow[seatNumber - 1] == 0) {
                                    choseRow[seatNumber - 1] = 1;

                                    System.out.print("\nEnter your name: ");   //extended method to get the information of a Person
                                    String name = optionInput.next();
                                    System.out.print("\nEnter your surname: ");
                                    String surname = optionInput.next();
                                    String email = "";
                                    while (!email.matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")) {
                                        if (!email.equals("")) {
                                            System.out.println("Invalid email.");
                                        }
                                        System.out.print("\nEnter your email: ");
                                        email = optionInput.next();
                                    }
                                    Person person = new Person(name, surname, email);
                                    Ticket ticket = new Ticket(1, seatNumber, 10, person);   //create a new ticket and adds the ticket in the new array list
                                    buyers.add(ticket);
                                    System.out.println("You have booked seat " +seatNumber + " in row " + rowNumber + ".");
                                    break;
                                } else {
                                    System.out.println("The seat is already booked!");
                                    continue;
                                }
                            }
                        }
                        if (rowNumber == 2) {
                            //check validity in row 2
                            choseRow = row2;
                            if (seatNumber < 0 || seatNumber > 17) {
                                System.out.println("Enter a valid seat number!");
                            }
                            if (seatNumber < 17 && seatNumber > 0) {
                                if (choseRow[seatNumber - 1] == 0) {
                                    choseRow[seatNumber - 1] = 1;

                                    System.out.print("\nEnter your name: ");   //extended method to get the information of a Person
                                    String name = optionInput.next();
                                    System.out.print("\nEnter your surname: ");
                                    String surname = optionInput.next();
                                    String email = "";
                                    while (!email.matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")) {
                                        if (!email.equals("")) {
                                            System.out.println("Invalid email.");
                                        }
                                        System.out.print("\nEnter your email: ");
                                        email = optionInput.next();
                                    }
                                    Person person = new Person(name, surname, email);
                                    Ticket ticket = new Ticket(2, seatNumber, 20, person);   //create a new ticket and adds the ticket in the new array list
                                    buyers.add(ticket);
                                    System.out.println("You have booked seat " + seatNumber + " in row " + rowNumber + ".");
                                    break;
                                } else {
                                    System.out.println("The seat is already booked!");
                                    continue;
                                }
                            }
                        }
                        if (rowNumber == 3) {
                            //check validity in row 3
                            choseRow= row3;
                            if (seatNumber < 0 || seatNumber > 21) {
                                System.out.println("Enter a valid seat number!");
                            }
                            if (seatNumber < 21 && seatNumber > 0) {
                                if (choseRow[seatNumber - 1] == 0) {
                                    choseRow[seatNumber - 1] = 1;

                                    System.out.print("\nEnter your name: ");   //extended method to get the information of a Person
                                    String name = optionInput.next();
                                    System.out.print("\nEnter your surname: ");
                                    String surname = optionInput.next();
                                    String email = "";
                                    while (!email.matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")) {
                                        if (!email.equals("")) {
                                            System.out.println("Invalid email.");
                                        }
                                        System.out.print("\nEnter your email: ");
                                        email = optionInput.next();
                                    }
                                    Person person = new Person(name, surname, email);
                                    Ticket ticket = new Ticket(3, seatNumber, 30, person);   //create a new ticket and adds the ticket in the new array list
                                    buyers.add(ticket);
                                    System.out.println("You have booked seat " + seatNumber + " in row " + rowNumber + ".");
                                    break;
                                } else {
                                    System.out.println("The seat is already booked!");
                                }
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input.\nEnter a valid option!");
                    }
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input.\nEnter a valid option!");
            }
        }
    }

    private static void print_seating_area() {
        System.out.println("     ***********");
        System.out.println("     *  STAGE  *");
        System.out.println("     ***********");
        System.out.print("    ");
        for (int i = 0; i < row1.length; i++) {   //print seating area row1
            if (row1[i] == 0) {
                System.out.print("O");
            }
            if (row1[i] == 1) {
                System.out.print("X");
            }
            if (i == (row1.length / 2) - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
        System.out.print("  ");
        for (int i = 0; i < row2.length; i++) {   //print seating area row2
            if (row2[i] == 0) {
                System.out.print("O");
            }
            if (row2[i] == 1) {
                System.out.print("X");
            }
            if (i == (row2.length / 2) - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
        for (int i = 0; i < row3.length; i++) {   //print seating area row3
            if (row3[i] == 0) {
                System.out.print("O");
            }
            if (row3[i] == 1) {
                System.out.print("X");
            }
            if (i == (row3.length / 2) - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    private static void cancel_ticket() {
        while (true) {
            try {
                Scanner rowInput = new Scanner(System.in);
                System.out.println("Enter the Row no you need(1-3):");
                int rowNumber = rowInput.nextInt();
                if (rowNumber > 3 || rowNumber < 1) {
                    System.out.println("Enter a Valid row number!");
                    continue;
                }
                while (true) {
                    try {
                        Scanner seatInput = new Scanner(System.in);
                        System.out.println("Enter the seat you want to remove:");
                        int seatNumber = seatInput.nextInt();
                        int[] removeRow;
                        if (rowNumber == 1) {
                            //check validity in row 1
                            removeRow = row1;
                            if (seatNumber < 0 || seatNumber > 13) {
                                System.out.println("Enter a valid seat number according to the rows!");
                            }
                            if (seatNumber < 13 && seatNumber > 0) {
                                if (removeRow[seatNumber - 1] == 1) {
                                    removeRow[seatNumber - 1] = 0;

                                    for (Ticket newObject : buyers) {
                                        if (newObject.getRow() == 1 && newObject.getSeat() == seatNumber) {
                                            buyers.remove(newObject);   //remove the object
                                            break;
                                        }
                                    }
                                    System.out.println("You have cleared seat " + seatNumber + " in row " + rowNumber + ".");
                                } else {
                                    System.out.println("The seat is not booked!");
                                    continue;
                                }
                                break;
                            }
                        }
                        if (rowNumber == 2) {
                            //check validity in row 2
                            removeRow = row2;
                            if (seatNumber < 0 || seatNumber > 17) {
                                System.out.println("Enter a valid seat number according to the rows!");
                            }
                            if (seatNumber < 17 && seatNumber > 0) {
                                if (removeRow[seatNumber - 1] == 1) {
                                    removeRow[seatNumber - 1] = 0;

                                    for (Ticket newObject : buyers) {
                                        if (newObject.getRow() == 2 && newObject.getSeat() == seatNumber) {
                                            buyers.remove(newObject);   //remove the object
                                            break;
                                        }
                                    }
                                    System.out.println("You have cleared seat " + seatNumber + " in row " + rowNumber + ".");
                                } else {
                                    System.out.println("The seat is not booked!");
                                    continue;
                                }
                                break;
                            }
                        }
                        if (rowNumber == 3) {
                            //check validity in row 3
                            removeRow = row3;
                            if (seatNumber < 0 || seatNumber > 21) {
                                System.out.println("Enter a valid seat number according to the rows!");
                            }
                            if (seatNumber < 21 && seatNumber > 0) {
                                if (removeRow[seatNumber - 1] == 1) {
                                    removeRow[seatNumber - 1] = 0;

                                    for (Ticket newObject : buyers) {
                                        if (newObject.getRow() == 3 && newObject.getSeat() == seatNumber) {
                                            buyers.remove(newObject);   //remove the object
                                            break;
                                        }
                                    }
                                    System.out.println("You have cleared seat " + seatNumber + " in row " + rowNumber + ".");
                                } else {
                                    System.out.println("The seat is not booked!");
                                    continue;
                                }
                                break;
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input.\nEnter a valid option!");
                    }
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input.\nEnter a valid option!");
            }
        }
    }

    private static void show_available() {
        System.out.print("Seats available in row 1: ");   //show available seats in row 1
        for (int k = 1; k <= row1.length; k++) {
            if (k == row1.length) {
                System.out.print(k + ".");
                break;
            }
            if (row1[k - 1] == 0) {
                System.out.print(k + ",");
            }
        }

        System.out.print("\nSeats available in row 2: ");   //show available seats in row 2
        for (int k = 1; k <= row2.length + 1; k++) {
            if (k == row2.length) {
                System.out.print(k + ".");
                break;
            }
            if (row2[k - 1] == 0) {
                System.out.print(k + ",");
            }
        }

        System.out.print("\nSeats available in row 3: ");   //show available seats in row 3
        for (int k = 1; k <= row3.length + 1; k++) {
            if (k == row3.length) {
                System.out.print(k + ".");
                break;
            }
            if (row3[k - 1] == 0) {
                System.out.print(k + ",");
            }
        }
    }

    private static void save() {
        try {
            FileWriter newFile = new FileWriter("seats.txt");

            newFile.write("Seats available in row 1: ");   //save data in row 1
            for (int k = 1; k <= row1.length + 1; k++) {
                if (k == row1.length) {
                    newFile.write(k + ".");
                    break;
                }
                if (row1[k - 1] == 0) {
                    newFile.write(k + ",");
                }
            }newFile.write("\n");

            newFile.write("\nSeats available in row 2: ");   //save data in row 2
            for (int k = 1; k <= row2.length + 1; k++) {
                if (k == row2.length) {
                    newFile.write(k + ".");
                    break;
                }
                if (row2[k - 1] == 0) {
                    newFile.write(k + ",");
                }
            }newFile.write("\n");

            newFile.write("\nSeats available in row 3: ");   //save data in row 3
            for (int k = 1; k <= row3.length + 1; k++) {
                if (k == row3.length) {
                    newFile.write(k + ".");
                    break;
                }
                if (row3[k - 1] == 0) {
                    newFile.write(k + ",");
                }
            }newFile.write("\n");
            newFile.close();   //close the file

        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    private static void load() {   //load data from file
        try {
            File newFile = new File("seats.txt");
            Scanner scan = new Scanner(newFile);
            while(scan.hasNextLine()){
                String loading= scan.nextLine();
                System.out.println(loading);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: seating chart file not found.");
        }
    }

    private static void show_tickets_info(){   //display the information of tickets
        System.out.println();
        double total = 0;
        for( Ticket ticket:buyers){
            total += ticket.getPrice();
            ticket.print();
            System.out.println();
        }
        System.out.println("Total Price is: €" + total);
    }

    private static void sort_tickets() {   //sorting ticket prices in ascending order
        Collections.sort(buyers, new Comparator<Ticket>() {
            @Override
            public int compare(Ticket t1, Ticket t2) {
                return (int) (t1.getPrice() - t2.getPrice());
            }
        });
        System.out.println();
        double total = 0;
        for (Ticket ticket : buyers) {
            total += ticket.getPrice();
            ticket.print();
            System.out.println();
        }
    }
}