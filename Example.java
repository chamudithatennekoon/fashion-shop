import java.util.*;
class Example{
	public static Scanner input = new Scanner(System.in);
	public static String[] orderIds = new String[0];
	public static String[] phoneNumbers = new String[0];
	public static String[] sizes = new String[0];
	
	public static int[] amount = new int[0];
	public static int[] qty = new int[0];
	public static int[] status = new int[0];
	
	public static final double xs = 600.00;
	public static final double s = 800.00;
	public static final double m = 900.00;
	public static final double l = 1000.00;
	public static final double xl = 1100.00;
	public static final double xxl = 1200.00;

	public static String[] removeElementStr(String[] arr, int j) {
		String[] tempArr = new String[arr.length-1];
			for(int i=0, k=0;i< arr.length ;i++){
				if(i!=j){
					tempArr[k]=arr[i];
					k++;
				}
			}
		arr = tempArr;
		return arr;
	}
	
	public static int[] removeElementInt(int[] arrInt, int j) {
		int[] tempArr = new int[arrInt.length-1];
			for(int i=0, k=0;i< arrInt.length ;i++){
				if(i!=j){
					tempArr[k]=arrInt[i];
					k++;
				}
			}
		arrInt = tempArr;
		return arrInt;
	}
	
	public static int getIndex(String phone){
		for (int i = 0; i < phoneNumbers.length; i++){
			if (phone.equals(phoneNumbers[i])){
				return i;
			}
		}
		return -1;
	}
	
	public static int getIndexOrder(String order){
		for (int i = 0; i < orderIds.length; i++){
			if (order.equals(orderIds[i])){
				return i;
			}
		}
		return -1;
	}
	
	public static String generateId(){
		if (orderIds.length>0){
			int id = Integer.parseInt(orderIds[orderIds.length-1].split("[R]")[1]);
			id++;
			return String.format("ODR%03d",id);
		}
		return "ODR001";
	}
	
	public static void placeOrder(){
		System.out.println("  _____  _                   ____          _           ");
        System.out.println(" |  __ \\| |                 / __ \\        | |          ");
        System.out.println(" | |__) | | __ _  ___ ___  | |  | |_ __ __| | ___ _ __ ");
        System.out.println(" |  ___/| |/ _` |/ __/ _ \\ | |  | | '__/ _` |/ _ \\ '__|");
        System.out.println(" | |    | | (_| | (_|  __/ | |__| | | | (_| |  __/ |   ");
        System.out.println(" |_|    |_|\\__,_|\\___\\___|  \\____/|_|  \\__,_|\\___|_|   ");
        System.out.println("                                                     ");
		
		System.out.println("______________________________________________________\n\n");
		
			String id = generateId();
			orderIds = extendArray(orderIds);
			orderIds[orderIds.length-1] = id;
			
			sizes = extendArray(sizes);
			amount = extendArray(amount);
			qty = extendArray(qty);
			
			phoneNumbers = extendArray(phoneNumbers);
			
		System.out.println("Order Id : "+orderIds[orderIds.length-1]);


		L2:do{
			System.out.print("\nEnter Customer Phone Number : ");
			String phone = input.next();
			
			if (isValidPhoneNumber(phone)){
				
				L1:do{
				
				System.out.print("\nEnter T-Shirt Size (XS/S/M/L/XL/XXL) : ");
				String size = input.next().toLowerCase();
				if (!size.equals("xs") && (!size.equals("s")) && (!size.equals("m")) && (!size.equals("l")) && (!size.equals("xl")) && (!size.equals("xxl")) ) {
					System.out.println("\n\t\tInvalid Size..! Please Try Again...");
					
					do{
						System.out.print("\n\tDo you want to try again? (y/n) : ");
						String yn = input.next().toLowerCase();
						
						if (yn.equals("y")){
							continue L1;
						}else if (yn.equals("n")){
							clearConsole(); home();
						}
						System.out.println("\n\t\tInvalid...");
					} while (true);
					
				} 
				
				
				L3:do{
				
					System.out.print("\nEnter QTY : ");
					int qt = input.nextInt();
					if (qt<=0) {
						System.out.print("\n\t\tInvalid QTY..! Please Try Again...");
						
						do{
							System.out.print("Do you want to try again? (y/n) : ");
							String yn = input.next().toLowerCase();
							
							if (yn.equals("y")){
								continue L3;
							}else if (yn.equals("n")){
								clearConsole(); home();
							}
							System.out.println("\n\t\tInvalid Input..! Please Try Again...");
						} while (true);
						
					} 
				
				//Price cal
				int s = 0;
				
				if ( size.equals("xs") ) {
					s = 600;
					} else if ( size.equals("s") ) {
					s = 800;
					} else if ( size.equals("m") ) {
					s = 900;
					} else if ( size.equals("l") ) {
					s = 1000;
					} else if ( size.equals("xl") ) {
					s = 1100;
					} else if ( size.equals("xxl") ) {
					s = 1200;
					}
				
				int tot = qt * s;
		
				qty[qty.length-1] += qt;
		
				amount[amount.length-1] = tot;
				
				double totD = tot;
				
				System.out.println("\n\t\tAmount : Rs. "+String.format("%.2f",totD));
				
				System.out.print("\n\tIf you want to place this order ? (y/n) : ");
				String op = input.next();
				if (op.equals("n")) {
					continue L1;
				} else if (!op.equals("y")) {
					System.out.print("\n\t\tInvalid Input..! Please Try Again...");
					}
				
				phoneNumbers[phoneNumbers.length-1] = phone;
				
				status = extendArray(status);
				status[status.length-1] = 1;
				
				sizes[sizes.length-1] = size;
				
				qty[qty.length-1] = qt;
				
				System.out.println("\n\t\tOrder Placed..!");
				
				do{
					System.out.print("\n\tDo you want to create another order ? (y/n) : ");
					String yn = input.next().toLowerCase();
					
					if (yn.equals("y")){
						placeOrder();
					}else if (yn.equals("n")){
						clearConsole(); home();
					}
					System.out.println("\n\t\tInvalid...");
				} while (true);
				
			} while (true);

		} while (true);
				
			} else{
				System.out.println("\n\t\tInvalid phone number. Please try again..");
				
				do{
					System.out.print("\n\tDo you want to try again? (y/n) : ");
					String yn = input.next().toLowerCase();
					
					if (yn.equals("y")){
						continue L2;
					}else if (yn.equals("n")){
						clearConsole(); home();
					}
					System.out.println("\n\t\tInvalid...");
				} while (true);
			}
			
				} while (true);

	}
	
	public static void searchCustomers(){
		
		System.out.println("   _____                     _        _____          _                            ");
        System.out.println("  / ____|                   | |      / ____|        | |                           ");
        System.out.println(" | (___   ___  __ _ _ __ ___| |__   | |    _   _ ___| |_ ___  _ __ ___   ___ _ __ ");
        System.out.println("  \\___ \\ / _ \\/ _` | '__/ __| '_ \\  | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__|");
        System.out.println("  ____) |  __/ (_| | | | (__| | | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |   ");
        System.out.println(" |_____/ \\___|\\__,_|_|  \\___|_| |_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|   ");
        System.out.println("                                                                                  ");

		System.out.println("__________________________________________________________________________________\n\n");
		
		L1:do{
			System.out.print("\nEnter Customer Phone Number : ");
			String phone = input.next();
			
			if (!isHavePhoneNumber(phone)){
				
				System.out.println("\n\t\tOrder ID : "+orderIds[getIndex(phone)]);

			int[] tempSizes = new int[6];
			 
			for (int j = 0; j < phoneNumbers.length; j++){
				 if (phoneNumbers[j].equals(phone)){
					 switch (sizes[j]){
						 case "xs": tempSizes[0] += qty[j];break; 
						 case "s": tempSizes[1] += qty[j];break; 
						 case "m": tempSizes[2] += qty[j];break; 
						 case "l": tempSizes[3] += qty[j];break; 
						 case "xl": tempSizes[4] += qty[j];break; 
						 case "xxl": tempSizes[5] += qty[j];break; 
					 }
				 }
			}
			
			double total = 0;

				 total += tempSizes[0] * xs;
				 total += tempSizes[1] * s;
				 total += tempSizes[2] * m;
				 total += tempSizes[3] * l;
				 total += tempSizes[4] * xl;
				 total += tempSizes[5] * xxl;
			
			System.out.println("\n\t\t+----------+---------+-----------------+");
			System.out.printf("\t\t|%-10s|%-9s|%15s  |%n","   Size","   QTY"," Amount");
			System.out.println("\t\t+----------+---------+-----------------+");
			
			System.out.printf("\t\t|%-10s|%-9s|%15s  |%n","    XS","    "+tempSizes[0],"  "+String.format("%.2f", (tempSizes[0] * xs)));
			System.out.printf("\t\t|%-10s|%-9s|%15s  |%n","    S","    "+tempSizes[1],"  "+String.format("%.2f", (tempSizes[1] * s)));
			System.out.printf("\t\t|%-10s|%-9s|%15s  |%n","    M","    "+tempSizes[2],"  "+String.format("%.2f", (tempSizes[2] * m)));
			System.out.printf("\t\t|%-10s|%-9s|%15s  |%n","    L","    "+tempSizes[3],"  "+String.format("%.2f", (tempSizes[3] * l)));
			System.out.printf("\t\t|%-10s|%-9s|%15s  |%n","    XL","    "+tempSizes[4],"  "+String.format("%.2f", (tempSizes[4] * xl)));
			System.out.printf("\t\t|%-10s|%-9s|%15s  |%n","    XXL","    "+tempSizes[5],"  "+String.format("%.2f", (tempSizes[5] * xxl)));

			System.out.println("\t\t+--------------------+-----------------+");
			System.out.printf("\t\t|%-20s|%15.2f  |%n"," Total Amount",total);
			System.out.println("\t\t+--------------------+-----------------+");
			
				do{
					System.out.print("\n\tDo you want to search another Customer ? (y/n) : ");
					String yn = input.next().toLowerCase();
						
					if (yn.equals("y")){
						continue L1;
					}else if (yn.equals("n")){
						clearConsole(); home();
					}
						System.out.println("\n\t\tInvalid Input..!");
				} while (true);
				
			} else {
				System.out.println("\n\t\tInvalid Input..!");
				
				do{
					System.out.print("Do you want to try again? (y/n) : ");
					String yn = input.next().toLowerCase();
					
					if (yn.equals("y")){
						continue L1;
					}else if (yn.equals("n")){
						clearConsole(); home();
					}
					System.out.println("\n\t\tInvalid Input..!");
				} while (true);
			}
		} while (true);
		
	}
	
	public static void searchOrder(){
		
		System.out.println("   _____                     _        ____          _           ");
        System.out.println("  / ____|                   | |      / __ \\        | |          ");
        System.out.println(" | (___   ___  __ _ _ __ ___| |__   | |  | |_ __ __| | ___ _ __ ");
        System.out.println("  \\___ \\ / _ \\/ _` | '__/ __| '_ \\  | |  | | '__/ _` |/ _ \\ '__|");
        System.out.println("  ____) |  __/ (_| | | | (__| | | | | |__| | | | (_| |  __/ |   ");
        System.out.println(" |_____/ \\___|\\__,_|_|  \\___|_| |_|  \\____/|_|  \\__,_|\\___|_|   ");
        System.out.println("                                                                 ");
		
		System.out.println("_________________________________________________________________\n\n");
		
		L1:do{
			System.out.print("\nEnter order ID : ");
			String order = input.next();
			
			if (!isValidOrder(order)){
				
					String st = "No";
					if (status[getIndexOrder(order)]==1) {
						st = "Processing";
					} else if (status[getIndexOrder(order)]==2) {
							st = "Delivering";
						} else if (status[getIndexOrder(order)]==3) {
							st = "Delivered";
						}
					
					System.out.println("\n\t\tPhone Number   : "+phoneNumbers[getIndexOrder(order)]);
					System.out.println("\n\t\tSize           : "+sizes[getIndexOrder(order)]);
					System.out.println("\n\t\tQTY            : "+qty[getIndexOrder(order)]);
					System.out.println("\n\t\tAmount         : "+amount[getIndexOrder(order)]);
					System.out.println("\n\t\tStatus         : "+st);

					do{
						System.out.print("\n\tDo you want to search another Order ? (y/n) : ");
						String yn = input.next().toLowerCase();
						
						if (yn.equals("y")){
							continue L1;
						}else if (yn.equals("n")){
							home();
						}
						System.out.println("\n\t\tInvalid Input..!");
					} while (true);
				
			} else {
				System.out.println("\n\t\tInvalid Input..!");
				
				do{
					System.out.print("\n\tDo you want to try again? (y/n) : ");
					String yn = input.next().toLowerCase();
					
					if (yn.equals("y")){
						continue L1;
					}else if (yn.equals("n")){
						home();
					}
					System.out.println("\n\t\tInvalid Input..!");
				} while (true);
			}
		} while (true);
		
	}
	
	public static void viewReports(){
		
		System.out.println("  _____                       _       ");
        System.out.println(" |  __ \\                     | |      ");
        System.out.println(" | |__) |___ _ __   ___  _ __| |_ ___ ");
        System.out.println(" |  _  // _ \\ '_ \\ / _ \\| '__| __/ __|");
        System.out.println(" | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\");
        System.out.println(" |_|  \\_\\___| .__/ \\___/|_|   \\__|___/");
        System.out.println("            | |                       ");
        System.out.println("            |_|                       ");
		
		System.out.println("_______________________________________\n\n");
		
		System.out.println("\n\t[1] Customer Reports  \t\t[2] Iteam Reports");
		System.out.println("\n\t[3] Order Reports  \t\t[4] Go back to Home");
		
		do{
			System.out.print("\nEnter Option : ");
			int option = input.nextInt();
			
			switch (option){
				case 1:clearConsole(); customerReports();break;
				case 2:clearConsole(); iteamReports();break;
				case 3:clearConsole(); orderReports();break;
				case 4:clearConsole(); home();break;
				default: System.out.println("\n\t\tInvalid Option..!");
			}
		} while (true);
		
	}
	
	public static void customerReports(){
		
		System.out.println("   _____          _                              _____                       _       ");
        System.out.println("  / ____|        | |                            |  __ \\                     | |      ");
        System.out.println(" | |    _   _ ___| |_ ___  _ __ ___   ___ _ __  | |__) |___ _ __   ___  _ __| |_ ___ ");
        System.out.println(" | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__| |  _  // _ \\ '_ \\ / _ \\| '__| __/ __|");
        System.out.println(" | |___| |_| \\__ \\ || (_) | | | | | |  __/ |    | | \\ \\  __/ |_) | (_) | |  | |\\__ \\");
        System.out.println("  \\____|\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|    |_|  \\_\\___| .__/ \\___/|_|  \\__|___/");
        System.out.println("                                                           | |                       ");
        System.out.println("                                                           |_|                       ");
		
		System.out.println("_____________________________________________________________________________________\n\n");
		
		System.out.println("\n\t[1] Best In Customers  \t\t[2] View Customers");
		System.out.println("\n\t[3] All Customer Reports  \t[4] Bact to List");
		System.out.println("\n\t[5] Back to Main Menu");
		
		do{
			System.out.print("\nEnter Option : ");
			int option = input.nextInt();
			
			switch (option){
				case 1:clearConsole(); bestInCustomers();break;
				case 2:clearConsole(); viewCustomers();break;
				case 3:clearConsole(); allCustomerReports();break;
				case 4:clearConsole(); viewReports();break;
				case 5:clearConsole(); home();break;
				default: System.out.println("\n\t\tInvalid Option..!");
			
			}
		} while (true);
	}
	
	public static void bestInCustomers(){
		
		System.out.println("  ____            _     _____          _____          _                                ");
        System.out.println(" |  _ \\          | |   |_   _|        / ____|        | |                               ");
        System.out.println(" | |_) | ___  ___| |_    | |  _ __   | |    _   _ ___| |_ ___  _ __ ___   ___ _ __ ___ ");
        System.out.println(" |  _ < / _ \\/ __| __|   | | | '_ \\  | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__/ __|");
        System.out.println(" | |_) |  __/\\__ \\ |_   _| |_| | | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |  \\__ \\");
        System.out.println(" |____/ \\___||___/\\__| |_____|_| |_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|  |___/");
        System.out.println("                                                                                       ");
        System.out.println("                                                                                       ");
		
		System.out.println("_______________________________________________________________________________________\n\n");
		
		String[] customers = new String[0];
		
		if (phoneNumbers.length>0){
			L1:for (int i = 0; i < phoneNumbers.length; i++){
				for (int j = 0; j < customers.length; j++){
					if (phoneNumbers[i].equals(customers[j])){
						continue L1;
					}
				}
				customers = extendArray(customers);
				customers[customers.length-1] = phoneNumbers[i];
			}
		}

		int[] tQty = new int[customers.length];
		int[] tAmount = new int[customers.length];
		
		for (int i = 0; i < customers.length; i++){
			 int[] tempSizes = new int[6];
			 
			 for (int j = 0; j < phoneNumbers.length; j++){
				 if (customers[i].equals(phoneNumbers[j])){
					 switch (sizes[j]){
						 case "xs": tempSizes[0] += qty[j];break; 
						 case "s": tempSizes[1] += qty[j];break; 
						 case "m": tempSizes[2] += qty[j];break; 
						 case "l": tempSizes[3] += qty[j];break; 
						 case "xl": tempSizes[4] += qty[j];break; 
						 case "xxl": tempSizes[5] += qty[j];break; 
					 }
				 }
			 }

			 int total = 0;
				 total += tempSizes[0] * xs;
				 total += tempSizes[1] * s;
				 total += tempSizes[2] * m;
				 total += tempSizes[3] * l;
				 total += tempSizes[4] * xl;
				 total += tempSizes[5] * xxl;

			tQty[i] = ( tempSizes[0] + tempSizes[1] + tempSizes[2] + tempSizes[3] + tempSizes[4]+ tempSizes[5] );
			tAmount[i] = total;
		}
		
		// sort array
		int n = tAmount.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (tAmount[j] < tAmount[j + 1]) {
					
                    // Swap amount
                    int tempAmount = tAmount[j];
                    tAmount[j] = tAmount[j + 1];
                    tAmount[j + 1] = tempAmount;

                    // Swap customer
                    String tempCustomers = customers[j];
                    customers[j] = customers[j + 1];
                    customers[j + 1] = tempCustomers;

                    // Swap qty
                    int tempQty = tQty[j];
                    tQty[j] = tQty[j + 1];
                    tQty[j + 1] = tempQty;
                }
            }
        }

			System.out.println("\n\t\t+---------------+---------+-----------------+");
			System.out.printf("\t\t|%-15s|%-9s|%15s  |%n","  Customer ID  "," All QTY"," Total Amount");
			System.out.println("\t\t+---------------+---------+-----------------+");
			
        for (int i = 0; i < n; i++) {
			
            System.out.printf("\t\t|%-15s|%-9s|%15s  |%n","  "+customers[i],"    "+tQty[i],String.format("%.2f", (double) tAmount[i]));
        }
			System.out.println("\t\t+---------------+---------+-----------------+");
			
		do{
			System.out.print("\n\tTo access the Main Menu, please enter 0 : ");
			String yn = input.next().toLowerCase();
					
			if (yn.equals("0")){
				clearConsole(); home();
			}else {
				System.out.println("\n\t\tInvalid Input..!");
			}
		} while (true);
		
	}
	
	public static void viewCustomers(){
		
		System.out.println(" __      ___                  _____          _                                ");
		System.out.println(" \\ \\    / (_)                / ____|        | |                               ");
		System.out.println("  \\ \\  / / _  _____      __ | |    _   _ ___| |_ ___  _ __ ___   ___ _ __ ___ ");
		System.out.println("   \\ \\/ / | |/ _ \\ \\ /\\ / / | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__/ __|");
		System.out.println("    \\  /  | |  __/\\ V  V /  | |___| |_| \\__ \\ || (_) | | | | | |  __/ |  \\__ \\");
		System.out.println("     \\/   |_|\\___| \\_/\\_/    \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|  |___/");

		System.out.println("_______________________________________________________________________________\n\n");
		
			System.out.println("\n\t\t+---------------+---------+-----------------+");
			System.out.printf("\t\t|%-15s|%-9s|%15s  |%n","  Customer ID  "," All QTY","   Total");
			System.out.println("\t\t+---------------+---------+-----------------+");
			
		for (int i = 0; i < orderIds.length; i++) {
			
			System.out.printf("\t\t|%-15s|%-9s|%15s  |%n","  "+phoneNumbers[i],"    "+qty[i],String.format("%.2f", (double) amount[i]));

		}
			System.out.println("\t\t+---------------+---------+-----------------+");
		

		do{
			System.out.print("\n\tTo access the Main Menu, please enter 0 : ");
			String yn = input.next().toLowerCase();
					
			if (yn.equals("0")){
				home();
			}else {
				System.out.println("\n\t\tInvalid Input..!");
			}
		} while (true);
		
	}
	
	public static void allCustomerReports(){
		
		System.out.println("           _ _    _____          _                              _____                       _       ");
        System.out.println("     /\\   | | |  / ____|        | |                            |  __ \\                     | |      ");
        System.out.println("    /  \\  | | | | |    _   _ ___| |_ ___  _ __ ___   ___ _ __  | |__) |___ _ __   ___  _ __| |_ ___ ");
        System.out.println("   / /\\ \\ | | | | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__| |  _  // _ \\ '_ \\ / _ \\| '__| __/ __|");
        System.out.println("  / ____ \\| | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |    | | \\ \\  __/ |_) | (_) | |  | |\\__ \\");
        System.out.println(" /_/    \\_\\_|_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|    |_|  \\_\\___| .__/ \\___/|_|   \\__|___/");
        System.out.println("                                                                          | |                       ");
        System.out.println("                                                                          |_|                       ");
		
		System.out.println("____________________________________________________________________________________________________\n\n");
		
		String[] customers = new String[0];
		
		if (phoneNumbers.length>0){
			L1:for (int i = 0; i < phoneNumbers.length; i++){
				for (int j = 0; j < customers.length; j++){
					if (phoneNumbers[i].equals(customers[j])){
						continue L1;
					}
				}

				customers = extendArray(customers); 
				customers[customers.length-1] = phoneNumbers[i];
			}
			
		}
		
		System.out.println("\t\t+---------------+-------+-------+-------+-------+-------+-------+---------------+");
		System.out.printf("\t\t|%-15s|%-7s|%-7s|%-7s|%-7s|%-7s|%-7s|%-15s|%n"," Phone Number","  XS","   S","   M","   L","  XL","  XXL"," Total Amount");
		System.out.println("\t\t+---------------+-------+-------+-------+-------+-------+-------+---------------+");

		for (int i = 0; i < customers.length; i++){
			 int[] tempSizes = new int[6];
			 
			 for (int j = 0; j < phoneNumbers.length; j++){
				 if (customers[i].equals(phoneNumbers[j])){
					 switch (sizes[j]){
						 case "xs": tempSizes[0] += qty[j];break; 
						 case "s": tempSizes[1] += qty[j];break;
						 case "m": tempSizes[2] += qty[j];break;
						 case "l": tempSizes[3] += qty[j];break;
						 case "xl": tempSizes[4] += qty[j];break;
						 case "xxl": tempSizes[5] += qty[j];break;
					 }
				 }
			 }
			 
			 //cal
			 double total = 0;
				 total += tempSizes[0] * xs;
				 total += tempSizes[1] * s;
				 total += tempSizes[2] * m;
				 total += tempSizes[3] * l;
				 total += tempSizes[4] * xl;
				 total += tempSizes[5] * xxl;
			 System.out.printf("\t\t|%15s|%7s|%7s|%7s|%7s|%7s|%7s|%15s|%n","","","","","","","","");
			 System.out.printf("\t\t|%-15s|%-7s|%-7s|%-7s|%-7s|%-7s|%-7s|%13.2f  |%n","  "+customers[i],"  "+tempSizes[0],"  "+tempSizes[1],"  "+tempSizes[2],"  "+tempSizes[3],"  "+tempSizes[4],"  "+tempSizes[5],total);
			 
		}
		System.out.println("\t\t+---------------+-------+-------+-------+-------+-------+-------+---------------+");
		
		do{
			System.out.print("\n\tTo access the Main Menu, please enter 0 : ");
			String yn = input.next().toLowerCase();
					
			if (yn.equals("0")){
				home();
			}else {
				System.out.println("\n\t\tInvalid Input..!");
			}
		} while (true);

	}
	
	public static void iteamReports(){
		
		System.out.println("  _____ _                   _____                       _       ");
        System.out.println(" |_   _| |                 |  __ \\                     | |      ");
        System.out.println("   | | | |_ ___ _ __ ___   | |__) |___ _ __   ___  _ __| |_ ___ ");
        System.out.println("   | | | __/ _ \\ '_ ` _ \\  |  _  // _ \\ '_ \\ / _ \\| '__| __/ __|");
        System.out.println("  _| |_| ||  __/ | | | | | | | \\ \\  __/ |_) | (_) | |  | |\\__ \\");
        System.out.println(" |_____|\\__\\___|_| |_| |_| |_|  \\_\\___| .__/ \\___/|_|  \\__|___/");
        System.out.println("                                      | |                       ");
        System.out.println("                                      |_|                       ");
		
		System.out.println("________________________________________________________________\n\n");
		
		System.out.println("\n\t[1] Best selling categories sorted by quantity");
		System.out.println("\n\t[2] Best selling items sorted by amount");
		System.out.println("\n\t[3] Go back to Home");
		
		do{
			System.out.print("\nEnter Option : ");
			int option = input.nextInt();
			
			switch (option){
				case 1:clearConsole(); bestSellingCat();break;
				case 2:clearConsole(); bestSellingItm();break;
				case 4:clearConsole(); home();break;
				default: System.out.println("\n\t\tInvalid Option..!");
			}
		} while (true);
		
	}
	
	public static void bestSellingCat(){
		
		System.out.println("   _____            _           _   _              ____ _________     __");
        System.out.println("  / ____|          | |         | | | |            / __ \\__   __\\ \\   / /");
        System.out.println(" | (___   ___  _ __| |_ ___  __| | | |__  _   _  | |  | | | |   \\ \\_/ / ");
        System.out.println("  \\___ \\ / _ \\| '__| __/ _ \\/ _` | | '_ \\| | | | | |  | | | |    \\   /  ");
        System.out.println("  ____) | (_) | |  | ||  __/ (_| | | |_) | |_| | | |__| | | |     | |   ");
        System.out.println(" |_____/ \\___/|_|   \\__\\___|\\__,_| |_.__/ \\__, |  \\___\\_\\ |_|     |_|   ");
        System.out.println("                                           __/ |                        ");
        System.out.println("                                          |___/                         ");
		
		System.out.println("________________________________________________________________________\n\n");
		
		int xxS = 0, sS = 0, mS = 0, lS = 0, xlS = 0, xxlS = 0;

		for (int i = 0; i < sizes.length; i++) {
			if (sizes[i].equals("xs")) {
				xxS += qty[i];
			} else if (sizes[i].equals("s")) {
				sS += qty[i];
			} else if (sizes[i].equals("m")) {
				mS += qty[i];
			} else if (sizes[i].equals("l")) {
				lS += qty[i];
			} else if (sizes[i].equals("xl")) {
				xlS += qty[i];
			} else if (sizes[i].equals("xxl")) {
				xxlS += qty[i];
			}
		}
		
		// create array
		int[] bestSellingCat= new int[6];
		
			bestSellingCat[0] = xxS;
			bestSellingCat[1] = sS;
			bestSellingCat[2] = mS;
			bestSellingCat[3] = lS;
			bestSellingCat[4] = xlS;
			bestSellingCat[5] = xxlS;
			
		double[] bSCAmount = new double[6];
			bSCAmount[0] = bestSellingCat[0] * xs;
			bSCAmount[1] = bestSellingCat[1] * s;
			bSCAmount[2] = bestSellingCat[2] * m;
			bSCAmount[3] = bestSellingCat[3] * l;
			bSCAmount[4] = bestSellingCat[4] * xl;
			bSCAmount[5] = bestSellingCat[5] * xxl;
			
		String[] size = new String[6];
			size[0] = "XS";
			size[1] = "S";
			size[2] = "M";
			size[3] = "L";
			size[4] = "XL";
			size[5] = "XXL";
			

		// sort
		int n = bestSellingCat.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (bestSellingCat[j] < bestSellingCat[j + 1]) {
                    // Swap cat
                    int tempBSCat = bestSellingCat[j];
                    bestSellingCat[j] = bestSellingCat[j + 1];
                    bestSellingCat[j + 1] = tempBSCat;

                    // Swap amount
                    double tempBSCAmount = bSCAmount[j];
                    bSCAmount[j] = bSCAmount[j + 1];
                    bSCAmount[j + 1] = tempBSCAmount;

                    // Swap size
                    String tempsize = size[j];
                    size[j] = size[j + 1];
                    size[j + 1] = tempsize;
                }
            }
        }

        // Print sorted data
			System.out.println("\n\t\t+--------+---------+-----------------+");
			System.out.printf("\t\t|%-6s|%-9s|%15s  |%n","  Size  ","   QTY","   Total Amount");
			System.out.println("\t\t+--------+---------+-----------------+");
			
        for (int i = 0; i < n; i++) {
			
			System.out.printf("\t\t|%-8s|%-9s|%15s  |%n","  "+size[i],"    "+bestSellingCat[i],String.format("%.2f", (double) bSCAmount[i]));

        }
			System.out.println("\t\t+--------+---------+-----------------+");
        
        do{
			System.out.print("\n\tTo access the Main Menu, please enter 0 : ");
			String yn = input.next().toLowerCase();
					
			if (yn.equals("0")){
				home();
			}else {
				System.out.println("\n\t\tInvalid Input..!");
			}
		} while (true);
		
	}
	
	public static void bestSellingItm(){
		
		System.out.println("   _____            _           _   _                                                  _   ");
        System.out.println("  / ____|          | |         | | | |               /\\                               | |  ");
        System.out.println(" | (___   ___  _ __| |_ ___  __| | | |__  _   _     /  \\   _ __ ___   ___  _   _ _ __ | |_ ");
        System.out.println("  \\___ \\ / _ \\| '__| __/ _ \\/ _` | | '_ \\| | | |   / /\\ \\ | '_ ` _ \\ / _ \\| | | | '_ \\| __|");
        System.out.println("  ____) | (_) | |  | ||  __/ (_| | | |_) | |_| |  / ____ \\| | | | | | (_) | |_| | | | | |_ ");
        System.out.println(" |_____/ \\___/|_|   \\__\\___|\\__,_| |_.__/ \\__, | /_/    \\_\\_| |_| |_|\\___/ \\__,_|_| |_|\\__|");
        System.out.println("                                           __/ |                                            ");
        System.out.println("                                          |___/                                             ");
		
		System.out.println("____________________________________________________________________________________________\n\n");
		
		int xxS = 0, sS = 0, mS = 0, lS = 0, xlS = 0, xxlS = 0;

		for (int i = 0; i < sizes.length; i++) {
			if (sizes[i].equals("xs")) {
				xxS += qty[i];
			} else if (sizes[i].equals("s")) {
				sS += qty[i];
			} else if (sizes[i].equals("m")) {
				mS += qty[i];
			} else if (sizes[i].equals("l")) {
				lS += qty[i];
			} else if (sizes[i].equals("xl")) {
				xlS += qty[i];
			} else if (sizes[i].equals("xxl")) {
				xxlS += qty[i];
			}
		}
		
		// create array
		int[] bestSellingItm= new int[6];
		
			bestSellingItm[0] = xxS;
			bestSellingItm[1] = sS;
			bestSellingItm[2] = mS;
			bestSellingItm[3] = lS;
			bestSellingItm[4] = xlS;
			bestSellingItm[5] = xxlS;
			
		double[] bSCAmount = new double[6];
			bSCAmount[0] = bestSellingItm[0] * xs;
			bSCAmount[1] = bestSellingItm[1] * s;
			bSCAmount[2] = bestSellingItm[2] * m;
			bSCAmount[3] = bestSellingItm[3] * l;
			bSCAmount[4] = bestSellingItm[4] * xl;
			bSCAmount[5] = bestSellingItm[5] * xxl;
			
		String[] size = new String[6];
			size[0] = "XS";
			size[1] = "S";
			size[2] = "M";
			size[3] = "L";
			size[4] = "XL";
			size[5] = "XXL";
			

		// sort
		int n = bestSellingItm.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (bSCAmount[j] < bSCAmount[j + 1]) {
                    // Swap amount
                    double tempBSCAmount = bSCAmount[j];
                    bSCAmount[j] = bSCAmount[j + 1];
                    bSCAmount[j + 1] = tempBSCAmount;

                    // Swap iteam
                    int tempBSCat = bestSellingItm[j];
                    bestSellingItm[j] = bestSellingItm[j + 1];
                    bestSellingItm[j + 1] = tempBSCat;

                    // Swap size
                    String tempsize = size[j];
                    size[j] = size[j + 1];
                    size[j + 1] = tempsize;
                }
            }
        }

        // Print sorted data
			System.out.println("\n\t\t+--------+---------+-----------------+");
			System.out.printf("\t\t|%-6s|%-9s|%15s  |%n","  Size  ","   QTY","   Total Amount");
			System.out.println("\t\t+--------+---------+-----------------+");
			
        for (int i = 0; i < n; i++) {
			
			System.out.printf("\t\t|%-8s|%-9s|%15s  |%n","  "+size[i],"    "+bestSellingItm[i],String.format("%.2f", (double) bSCAmount[i]));
			
        }
			System.out.println("\t\t+--------+---------+-----------------+");
        
        do{
			System.out.print("\n\tTo access the Main Menu, please enter 0 : ");
			String yn = input.next().toLowerCase();
					
			if (yn.equals("0")){
				home();
			}else {
				System.out.println("\n\t\tInvalid Input..!");
			}
		} while (true);
		
	}
	
	public static void orderReports(){
		
		System.out.println("   ____          _             _____                       _       ");
        System.out.println("  / __ \\        | |           |  __ \\                     | |      ");
        System.out.println(" | |  | |_ __ __| | ___ _ __  | |__) |___ _ __   ___  _ __| |_ ___ ");
        System.out.println(" | |  | | '__/ _` |/ _ \\ '__| |  _  // _ \\ '_ \\ / _ \\| '__| __/ __|");
        System.out.println(" | |__| | | | (_| |  __/ |    | | \\ \\  __/ |_) | (_) | |  | |\\__ \\");
        System.out.println("  \\____/|_|  \\__,_|\\___|_|    |_|  \\_\\___| .__/ \\___/|_|  \\__|___/");
        System.out.println("                                         | |                       ");
        System.out.println("                                         |_|                       ");
		
		System.out.println("___________________________________________________________________\n\n");
		
		System.out.println("\n\t[1] All Orders");
		System.out.println("\n\t[2] Orders by Amount");
		System.out.println("\n\t[3] Go back to Home");
		
		do{
			System.out.print("\nEnter Option : ");
			int option = input.nextInt();
			
			switch (option){
				case 1:clearConsole(); allOrders();break;
				case 2:clearConsole(); ordersbyAmount();break;
				case 3:clearConsole(); home();break;
				default: System.out.println("\n\t\tInvalid Option..!");
			}
		} while (true);
		
	}
	
	public static void allOrders(){
		
		System.out.println("           _ _  __      ___                  ____          _               ");
        System.out.println("     /\\   | | | \\ \\    / (_)                / __ \\        | |              ");
        System.out.println("    /  \\  | | |  \\ \\  / / _  _____      __ | |  | |_ __ __| | ___ _ __ ___ ");
        System.out.println("   / /\\ \\ | | |   \\ \\/ / | |/ _ \\ \\ /\\ / / | |  | | '__/ _` |/ _ \\ '__/ __|");
        System.out.println("  / ____ \\  | |    \\  /  | |  __/\\ V  V /  | |__| | | | (_| |  __/ |  \\__ \\");
        System.out.println(" /_/    \\_\\_|_|     \\/   |_|\\___| \\_/\\_/    \\____/|_|  \\__,_|\\___|_|  |___/");
        System.out.println("                                                                            ");
        System.out.println("                                                                            ");
		
		System.out.println("____________________________________________________________________________\n\n");
		
			System.out.println("\n\t\t+---------+--------------+------+------+---------------+-----------------+");
			System.out.printf("\t\t|%-10s|%-13s|%-6s|%-6s|%-15s|%-15s  |%n"," Order ID "," Customer ID "," Size ","  QTY","     Amount","     Status");
			System.out.println("\t\t+---------+--------------+------+------+---------------+-----------------+");
		
		for (int i = orderIds.length-1 ; i >= 0 ; i--) {
			String st = "";
			if (status[i] == 1) {
				st = "Processing";
			}
			if (status[i] == 2) {
				st = "Delivering";
			}
			if (status[i] == 3) {
				st = "Delivered";
			}
			
			System.out.printf("\t\t|%-10s|%-13s|%-6s|%-6s|%15s|%-15s  |%n","  "+orderIds[i],"  "+phoneNumbers[i],"  "+sizes[i],"  "+qty[i],String.format("%.2f", (double) amount[i])+"  ","   "+st);

		}
			System.out.println("\t\t+---------+--------------+------+------+---------------+-----------------+");
		
		do{
			System.out.print("\n\tTo access the Main Menu, please enter 0 : ");
			String yn = input.next().toLowerCase();
					
			if (yn.equals("0")){
				clearConsole(); home();
			}else {
				System.out.println("\n\t\tInvalid Input..!");
			}
		} while (true);

	}
	
	public static void ordersbyAmount(){
		
		System.out.println("   ____          _             _                                                  _   ");
        System.out.println("  / __ \\        | |           | |               /\\                               | |  ");
        System.out.println(" | |  | |_ __ __| | ___ _ __  | |__  _   _     /  \\   _ __ ___   ___  _   _ _ __ | |_ ");
        System.out.println(" | |  | | '__/ _` |/ _ \\ '__| | '_ \\| | | |   / /\\ \\ | '_ ` _ \\ / _ \\| | | | '_ \\| __|");
        System.out.println(" | |__| | | | (_| |  __/ |    | |_) | |_| |  / ____ \\| | | | | | (_) | |_| | | | | |_ ");
        System.out.println("  \\____/|_|  \\__,_|\\___|_|    |_.__/ \\__, | /_/    \\_\\_| |_| |_|\\___/ \\__,_|_| |_|\\__|");
        System.out.println("                                      __/ |                                            ");
        System.out.println("                                     |___/                                             ");
		
		System.out.println("_______________________________________________________________________________________\n\n");
		
		
		// sort
		int n = orderIds.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (amount[j] < amount[j + 1]) {
                   // Swap orderid
                   String tempOrderIds = orderIds[j];
                   orderIds[j] = orderIds[j + 1];
                   orderIds[j + 1] = tempOrderIds;
                   
                   // Swap phone numbers
                   String tempPhoneNumbers = phoneNumbers[j];
                   phoneNumbers[j] = phoneNumbers[j + 1];
                   phoneNumbers[j + 1] = tempPhoneNumbers;
                   
                   // Swap size
                   String tempSizes = sizes[j];
                   sizes[j] = sizes[j + 1];
                   sizes[j + 1] = tempSizes;
                   
                   // Swap QTY
                   int tempQty = qty[j];
                   qty[j] = qty[j + 1];
                   qty[j + 1] = tempQty;
                   
                   // Swap amount
                   int tempAmount = amount[j];
                   amount[j] = amount[j + 1];
                   amount[j + 1] = tempAmount;
                   
                   // Swap amount
                   int tempStatus = status[j];
                   status[j] = status[j + 1];
                   status[j + 1] = tempStatus;
   
                }
            }
        }

        // Print sorted data
			System.out.println("\n\t\t+---------+--------------+------+------+---------------+-----------------+");
			System.out.printf("\t\t|%-10s|%-13s|%-6s|%-6s|%-15s|%-15s  |%n"," Order ID "," Customer ID "," Size ","  QTY","     Amount","     Status");
			System.out.println("\t\t+---------+--------------+------+------+---------------+-----------------+");
        
        for (int i = 0; i < n; i++) {
			String st = "";
			if (status[i] == 1) {
				st = "Processing";
			}
			if (status[i] == 2) {
				st = "Delivering";
			}
			if (status[i] == 3) {
				st = "Delivered";
			}
			System.out.printf("\t\t|%-10s|%-13s|%-6s|%-6s|%15s|%-15s  |%n","  "+orderIds[i],"  "+phoneNumbers[i],"  "+sizes[i],"  "+qty[i],String.format("%.2f", (double) amount[i])+"  ","   "+st);

        }
			System.out.println("\t\t+---------+--------------+------+------+---------------+-----------------+");
        
        do{
			System.out.print("\n\tTo access the Main Menu, please enter 0 : ");
			String yn = input.next().toLowerCase();
					
			if (yn.equals("0")){
				clearConsole(); home();
			}else {
				System.out.println("\n\t\tInvalid Input..!");
			}
		} while (true);
	
	}
	
	public static void changeOrderStatus(){
		
		System.out.println("   ____          _              _____ _        _             ");
        System.out.println("  / __ \\        | |            / ____| |      | |            ");
        System.out.println(" | |  | |_ __ __| | ___ _ __  | (___ | |_ __ _| |_ _   _ ___ ");
        System.out.println(" | |  | | '__/ _` |/ _ \\ '__|  \\___ \\| __/ _` | __| | | / __|");
        System.out.println(" | |__| | | | (_| |  __/ |     ____) | || (_| | |_| |_| \\__ \\");
        System.out.println("  \\____/|_|  \\__,_|\\___|_|    |_____/ \\__\\__,_|\\__|\\__,_|___/");
        System.out.println("                                                              ");
		
		System.out.println("______________________________________________________________\n\n");
		
		System.out.println("\n+--------------------------------------------------+");
		System.out.printf("|%50s|%n","Change Order Status               ");
		System.out.println("+--------------------------------------------------+");
		
		L1:do{
			System.out.print("\nEnter order ID : ");
			String order = input.next();
			
			if (!isValidOrder(order)){
				
					String st = "No";
					if (status[getIndexOrder(order)]==1) {
						st = "Processing";
					} else if (status[getIndexOrder(order)]==2) {
							st = "Delivering";
					} else if (status[getIndexOrder(order)]==3) {
							st = "Delivered";
						}
					
					System.out.println("\n\t\tPhone Number   : "+phoneNumbers[getIndexOrder(order)]);
					System.out.println("\n\t\tSize           : "+sizes[getIndexOrder(order)]);
					System.out.println("\n\t\tQTY            : "+qty[getIndexOrder(order)]);
					System.out.println("\n\t\tAmount         : "+amount[getIndexOrder(order)]);
					System.out.println("\n\t\tStatus         : "+st);
					
						do{
							System.out.print("\nDo you want to change this Order Status ? (y/n) : ");
							String yn = input.next().toLowerCase();
							
							if (yn.equals("y")){
								
								if (status[getIndexOrder(order)]==1) {
									System.out.print("\n\t[1] Order Delivering");
									System.out.print("\t[2] Delivered");
											
									System.out.print("\n\nEnter Option : ");
									int option = input.nextInt();
												
									switch (option){
										case 1:status[getIndexOrder(order)] = 2;
												System.out.println("\n\t\tOrder status changed successfully..!");
												continue L1;
										case 2:status[getIndexOrder(order)] = 3;
												System.out.println("\n\t\tOrder status changed successfully..!");
												continue L1;
										default: System.out.println("\n\t\tInvalid Option..!");
												continue L1;
										}
											

								} else if (status[getIndexOrder(order)]==2) {
									System.out.print("\n\t[1] Delivered");
											
									System.out.print("\n\nEnter Option : ");
									int option = input.nextInt();
												
									switch (option){
										case 1:status[getIndexOrder(order)] = 3;
												System.out.println("\n\t\tOrder status changed successfully..!");
												continue L1;
										default: System.out.println("\n\t\tInvalid Option..!");
												continue L1;
										}
										
								} else if (status[getIndexOrder(order)]==3) {
										System.out.println("\n\t\tCan't change this order status. Order is already delivered..!");
										continue L1;
									}
								
							}else if (yn.equals("n")){
								continue L1;
							}
							System.out.println("\n\t\tInvalid Input..!");
						} while (true);
					
				
			}else{
				System.out.println("\n\t\tInvalid Input..!");
				
				do{
					System.out.print("Do you want to try again? (y/n) : ");
					String yn = input.next().toLowerCase();
					
					if (yn.equals("y")){
						continue L1;
					}else if (yn.equals("n")){
						clearConsole(); home();
					}
					System.out.println("\n\t\tInvalid Input..!");
				} while (true);
				
			}
		} while (true);
		
	}
	
	public static void deleteOrder(){
		
		System.out.println("  _____       _      _          ____          _           ");
        System.out.println(" |  __ \\     | |    | |        / __ \\        | |          ");
        System.out.println(" | |  | | ___| | ___| |_ ___  | |  | |_ __ __| | ___ _ __ ");
        System.out.println(" | |  | |/ _ \\ |/ _ \\ __/ _ \\ | |  | | '__/ _` |/ _ \\ '__|");
        System.out.println(" | |__| |  __/ |  __/ ||  __/ | |__| | | | (_| |  __/ |   ");
        System.out.println(" |_____/ \\___|_|\\___|\\__\\___|  \\____/|_|  \\__,_|\\___|_|   ");
        System.out.println("                                                          ");
    
		System.out.println("__________________________________________________________\n\n");
		
		L1:do{
			System.out.print("\nEnter order ID : ");
			String order = input.next();
			
			if (!isValidOrder(order)){
				
					String st = "No";
					if (status[orderIds.length-1]==1) {
					st = "Delivering";
					}
					
					System.out.println("\n\t\tPhone Number   : "+phoneNumbers[getIndexOrder(order)]);
					System.out.println("\n\t\tSize Size   : "+sizes[getIndexOrder(order)]);
					System.out.println("\n\t\tTotal Amount   : "+amount[getIndexOrder(order)]);
					System.out.println("\n\t\tStatus   : "+st);
					
					System.out.print("Do you want to delete this Order ? (y/n) : ");
					String del= input.next().toLowerCase();
					
					if (del.equals("y")){
						
						int j = getIndexOrder(order);
						
						String[] arr = removeElementStr(phoneNumbers, j);
						phoneNumbers = arr;
						
						arr = removeElementStr(orderIds, j);
						orderIds = arr;
						
						arr = removeElementStr(sizes, j);
						sizes = arr;
						
						int[] arrInt = removeElementInt(status, j);
						status = arrInt;
						
						arrInt = removeElementInt(amount, j);
						amount = arrInt;
						
						arrInt = removeElementInt(qty, j);
						qty = arrInt;
						
						System.out.println("\n\t\tOrder Successfully Deleted..!");
						
					} else if (del.equals("n")){
						clearConsole(); home();
					} else {
					System.out.println("\n\t\tInvalid Input..!");
				}
					
					do{
						System.out.print("\nDo you want to delete another Order ? (y/n) : ");
						String yn = input.next().toLowerCase();
						
						if (yn.equals("y")){
							continue L1;
						}else if (yn.equals("n")){
							clearConsole(); home();
						}
						System.out.println("\n\t\tInvalid Input..!");
					} while (true);
				
			}else{
				System.out.println("\n\t\tInvalid Input..!");
				
				do{
					System.out.print("Do you want to try again? (y/n) : ");
					String yn = input.next().toLowerCase();
					
					if (yn.equals("y")){
						continue L1;
					}else if (yn.equals("n")){
						clearConsole(); home();
					}
					System.out.println("\n\t\tInvalid Input..!");
				} while (true);
			}
		} while (true);
		
	}
	
	public static boolean isValidPhoneNumber(String phone){
		
		if (phone.charAt(0) == '0') {
			if (phone.length() == 10) {
				return true;
			} 
		}	return false;
	}
	
	public static boolean isHavePhoneNumber(String phone){
		
		for (int i = 0; i < phoneNumbers.length; i++){
			if (phone.equals(phoneNumbers[i])){
				return false;
			}
		}
		return true;
	}

	
	public static boolean isValidOrder(String order){
		for (int i = 0; i < orderIds.length; i++){
			if (order.equals(orderIds[i])){
				return false;
			}
		}
		return true;
	}
	
	public static String[] extendArray(String[] br){
		String[] temp = new String[br.length+1];
		for (int i = 0; i < br.length; i++){
			temp[i] = br[i];
		}
		return temp;
	}
	
	public static int[] extendArray(int[] br){
		int[] temp = new int[br.length+1];
		for (int i = 0; i < br.length; i++){
			temp[i] = br[i];
		}
		return temp;
	}
	
	public final static void clearConsole() {
			try {
				final String os = System.getProperty("os.name");
					if (os.contains("Windows")) {
						new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();} else {
						System.out.print("\033[H\033[2J");
						System.out.flush();
					}
				} catch (final Exception e) {
				e.printStackTrace();
				// Handle any exceptions.
			}
		}
	
	public static void home(){
		
		System.out.println("\n  /$$$$$$$$                 /$$       /$$                            /$$$$$$  /$$                          ");
        System.out.println("  | $$_____/                | $$      |__/                           /$$__  $$| $$                          ");
        System.out.println("  | $$    /$$$$$$   /$$$$$$$| $$$$$$$  /$$  /$$$$$$  /$$$$$$$       | $$  \\__/| $$$$$$$   /$$$$$$   /$$$$$$ ");
        System.out.println("  | $$$$$|____  $$ /$$_____/| $$__  $$| $$ /$$__  $$| $$__  $$      |  $$$$$$ | $$__  $$ /$$__  $$ /$$__  $$");
        System.out.println("  | $$__/ /$$$$$$$|  $$$$$$ | $$  \\ $$| $$| $$  \\ $$| $$  \\ $$       \\____  $$| $$  \\ $$| $$  \\ $$| $$  \\ $$");
        System.out.println("  | $$   /$$__  $$ \\____  $$| $$  | $$| $$| $$  | $$| $$  | $$       /$$  \\ $$| $$  | $$| $$  | $$| $$  | $$");
        System.out.println("  | $$  |  $$$$$$$ /$$$$$$$/| $$  | $$| $$|  $$$$$$/| $$  | $$      |  $$$$$$/| $$  | $$|  $$$$$$/| $$$$$$$/");
        System.out.println("  |__/   \\_______/|_______/ |__/  |__/|__/ \\______/ |__/  |__/       \\______/ |__/  |__/ \\______/ | $$____/ ");
        System.out.println("                                                                                                  | $$      ");
        System.out.println("                                                                                                  | $$      ");
        System.out.println("                                                                                                  |__/      ");

		System.out.println("\n------------------------------------------------------------------------------------------------------------\n");
		
		System.out.println("\n\t[1] Place Order  \t\t[2] Search Customers");
		System.out.println("\n\t[3] Search Order  \t\t[4] View Reports");
		System.out.println("\n\t[5] Change Order Status  \t[6] Delete Customers");
		
		do{
			System.out.print("\nEnter Option : ");
			int option = input.nextInt();
			
			switch (option){
				case 1:clearConsole(); placeOrder();break;
				case 2:clearConsole(); searchCustomers();break;
				case 3:clearConsole(); searchOrder();break;
				case 4:clearConsole(); viewReports();break;
				case 5:clearConsole(); changeOrderStatus();break;
				case 6:clearConsole(); deleteOrder();break;
				default:System.out.println("\n\t\tInvalid Option..!");
			
			}
		} while (true);
	}
	
	public static void main(String[] args){
		home();
	}
}
