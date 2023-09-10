P1 = input("Enter Player1's choice - R for Rock, P for paper OR S for Scissors ?\n").lower()
P2 = input("Enter Player2's choice - R for Rock, P for paper OR S for Scissors ?\n").lower()

print(f"Player1's Choice:{P1}")

print(f"Player2's choice: {P2}")

if P1 == P2:
    print("Its a draw")
elif ((P1 == 'r') and (P2 == 'p')) or (P1 == 'p' and P2 == 's') or (P1 == 's' and P2 == 'r'):
    print("Player2 wins!!")
elif (P1 == 'r' and P2 == 's') or (P1 == 'p' and P2 == 'r') or (P1 == 'r' and P2 == 'p'):
    print("Player1 wins!!")