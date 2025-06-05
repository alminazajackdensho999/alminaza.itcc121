# Bornok's Spa Services

# main function
def main():
    # Services (items) with prices (values) dictionary
    services = {
        1: ("Swedish Massage", 500),
        2: ("Shiatsu Massage", 600),
        3: ("Hot Stone Massage", 800),
        4: ("Foot Massage", 300),
        5: ("Facial", 400)
    }

    # empty list
    selected = []

    # services for loop
    while True:
        # Display all available services and their prices
        print("\nServices:")
        for number, (name, price) in services.items():
            print(f"{number}. {name} - PHP {price}")

        # user option
        print("\nOptions:")
        print("1. Add service")
        print("2. Remove service")
        print("3. Checkout")
        print("4. Cancel")
        action = input("Choose an option (1-4): ")

        # If user wants to add a service
        if action == "1":
            try:
                choice = int(input("Enter service number to add: "))
                if choice in services:
                    selected.append(choice)
                    print(f"Added {services[choice][0]}")
                else:
                    print("Invalid service number.")
            except ValueError:
                print("Please enter a valid number.")

        elif action == "2":
            try:
                choice = int(input("Enter service number to remove: "))
                if choice in selected:
                    selected.remove(choice)
                    print(f"Removed {services[choice][0]}")
                else:
                    print("Service not in selection.")
            except ValueError:
                print("Please enter a valid number.")

        elif action == "3":
            if not selected:
                print("No services selected.")
                continue 

            # Show the selected services and compute the total price
            print("\nSelected Services:")
            total = 0
            for i in selected:
                name, price = services[i]
                print(f"- {name}: PHP {price}")
                total += price

            # Ask if the client is eligible for a discount or wants to cancel
            while True:
                print("\nAre you:")
                print("1. Senior (20% discount)")
                print("2. Student (10% discount)")
                print("3. None")
                print("4. Cancel transaction")
                discount_choice = input("Choose an option (1-4): ")

                if discount_choice == "1":
                    total *= 0.8  # Apply 20% discount
                    break
                elif discount_choice == "2":
                    total *= 0.9  # Apply 10% discount
                    break
                elif discount_choice == "3":
                    break  # No discount applied
                elif discount_choice == "4":
                    print("Transaction cancelled.")
                    return  # Exit the function completely
                else:
                    print("Invalid choice. Please select 1, 2, 3, or 4.")

            # Show the final amount after discount
            print(f"\n\n\n****Client's Bill Summary*****\n\nTotal after discount: PHP {total:.2f}")
            print("\nCome again!\nThank you!")
            break  # Exit the loop after checkout

        # If user decides to cancel the transaction
        elif action == "4":
            print("Transaction cancelled.")
            break  # Exit the loop

        # If user enters an invalid option
        else:
            print("Invalid option. Please choose 1, 2, 3, or 4.")


# calls mainfunction to run the program
main()

