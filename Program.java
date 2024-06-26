class Program {
    public static void main(String[] args) {

        boolean isrunning = true;

        System.out.println();
        while (isrunning){
            
            //escape codes
            //System.out.println("\033[H  \033[2j");

            String userInput = Input.StringInput("What would you like to do? ", 'U');

            Tuple<String, String> output = Action.DoAction(userInput);
            String eventType = output.getFirst();
            String message = output.getSecond();

            Screen.ResetTop();
            Screen.ResetBottom();

            Screen.AddToTop(message);
            if (eventType == "QUIT") { isrunning = false; }

            // switch (eventType) {
            //     case "MOVE":

            //         if(successful == "T") { Screen.AddToTop("You moved " + output.getSecond().getSecond() + "."); }
            //         else if(successful == "F") { Screen.AddToTop("You can't go that way."); }
            //         else if(successful == "L") { Screen.AddToTop("The door is locked."); }
            //         else if(successful == "E") { Screen.AddToTop("You have encountered an error."); }
            //         break;
                
            //     case "UNLOCK":

            //         if(successful == "T") { Screen.AddToTop("You unlocked the door."); }
            //         else if(successful == "F") { Screen.AddToTop("There is nothing to unlock."); }
            //         else if(successful == "L") { Screen.AddToTop("You don't have the key."); }
            //         else if(successful == "E") { Screen.AddToTop("You have encountered an error."); }
            //         break;

            //     case "TAKE":

            //         if(successful == "T") { Screen.AddToTop("You took the " + output.getSecond().getSecond() + "."); }
            //         else if(successful == "F"){ Screen.AddToTop("You looked around the " + Map.GetCurrentLocation().GetName() + " but you see nothing special."); }
            //         else if(successful == "N") { Screen.AddToTop("You didn't take anything."); }
            //         else if(successful == "O") { Screen.AddToTop("You have to much stuff in your inventory."); }
            //         else if(successful == "E") { Screen.AddToTop("You have encountered an error."); }
            //         break;

            //     case "DROP":

            //     if(successful == "T") { Screen.AddToTop("You dropped the " + output.getSecond().getSecond() + "."); }
            //     else if(successful == "F"){ Screen.AddToTop("You don't have anything to drop."); }
            //     else if(successful == "N") { Screen.AddToTop("You didn't drop anything."); }
            //     else if(successful == "O") { Screen.AddToTop("This room is to cluttered. You can't drop anything."); }
            //     else if(successful == "E") { Screen.AddToTop("You have encountered an error."); }
            //     break;

            //     case "INSPECT":

            //     case "LOOK":

            //         Screen.AddToTop("You took a look around the " + Map.GetCurrentLocation().GetName() + ".");
            //         break;

            //     case "QUIT":

            //         isrunning = false;
            //         Screen.AddToTop("Thanks for playing!");
            //         break;

            //     case "INVALID":

            //         Screen.AddToTop("That is not an action.");
            //         break;
                    
            //     default:

            //         break;
            // }

            if (Map.GetCurrentLocation().GetName() == "Courtyard") {
                Screen.AddToTop("Congrats! You escaped the mansion!");
                isrunning = false;
            }
        }
        Input.closeScanner();
    }
}



/*
List<string> compass = new List<string>
{
    "_______________________________________  ",
    "|                                     |  ",
    "|  Move around with:    North: N      |  ",
    "|                       South: S      |  ",
    "|   nw  N  ne      U    East: E       |  ",
    "|     \\ | /       /|\\   West: W       |",
    "|      \\|/         |    NorthEast: NE | ",
    "| W-----|-----E    |    NorthWest: NW |  ",
    "|      /|\\         |    SouthEast: SE | ",
    "|     / | \\       \\|/   SouthWest: SW |",
    "|   sw  S  se      D    Up: U         |  ",
    "|                       Down: D       |  ",
    "|                                     |  ",
    "|  Other actions:                     |  ",
    "|                                     |  ",
    "|     Look: L                         |  ",
    "|     Take: T                         |  ",
    "|     Unlock: UL                      |  ",
    "|     Quit: Q                         |  ",
    "|                                     |  ",
    "|                                     |  ",
    "|                                     |  ",
    "|                                     |  ",
    "|                                     |  ",
    "|_____________________________________|  "
};
*/

        // List<string> menu = new List<string>
        // {
        //     "   Please choose an action:",
        //     "   Move: N, S, E, W, NE, 
        //                 NW, SE, SW, U, D",
        //     "   Look: L",
        //     "   Take: T",
        //     "   Unlock: UL",
        //     "   Quit: Q",

        //     "   View Inventory: I",
        //     "   Use Item: R",
        //     "   Talk to NPC: T",
        //     "   View Map: M",
        // };
