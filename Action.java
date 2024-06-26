import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class Action {

    private static String _north = "W";
    private static String _south = "S";
    private static String _east = "D";
    private static String _west = "A";
    private static String _northEast = "E";
    private static String _northWest = "Q";
    private static String _southEast = "C";
    private static String _southWest = "Z";
    private static String _up = " ";
    private static String _down = "X";

    private static String _look = "1";
    private static String _inspect = "2";
    private static String _take = "3";
    private static String _drop = "4";
    private static String _unlock = "5";
    private static String _quit = "0";

    public static Tuple<String, String> DoAction (String userInput) {
        if (
            userInput.equals(_north) || userInput .equals(_south) || userInput .equals(_east) || userInput .equals(_west) || 
            userInput .equals(_northEast) || userInput .equals(_northWest) || userInput .equals(_southEast) || userInput .equals(_southWest) || 
            userInput .equals(_up) || userInput .equals(_down)
        ) { 
            //Screen.SetHasLooked(false);
            String output = Move(userInput);
            Screen.UpdateTitle("You are currently in the " + Map.GetCurrentLocation().GetName() + ".");
            Screen.UpdateDescription(Map.GetCurrentLocation().GetDescription1());
            return new Tuple<>("MOVE", output); 
        }
        else if (userInput.equals(_unlock)){ return new Tuple<>("UNLOCK", Unlock()); }
        else if (userInput.equals(_take)){ return new Tuple<>("TAKE", Take()); }
        else if (userInput.equals(_drop)){ return new Tuple<>("DROP", Drop()); }
        else if (userInput.equals(_inspect)){ return new Tuple<>("INSPECT", Inspect()); }
        else if (userInput.equals(_look)){ return new Tuple<>("LOOK", Look()); }
        else if (userInput.equals(_quit)){ return new Tuple<>("QUIT", "Thanks for playing!"); }
        else { return new Tuple<>("INVALID", "That is not an action."); }
    }

    private static String Move(String direction)
    {
        String output;
        if(direction.equals(_north)){
            if (Map.GetCurrentLocation().GetNorth() == null) { 
                output = Color.RED + "There is nothing north of here." + Color.RESET; 
            }
            else if (Map.GetCurrentLocation().GetNorth().GetUnlocked() == false) { 
                output = "The north door is locked."; 
            }
            else { 
                Map.GetCurrentLocation().SetIsCurrent(false);
                Map.SetCurrentLocation(Map.GetCurrentLocation().GetNorth());
                Map.GetCurrentLocation().SetVisited(true);
                Map.GetCurrentLocation().SetIsCurrent(true);
                output = "You moved north."; 
            }
        }

        else if(direction.equals(_south)){
            if (Map.GetCurrentLocation().GetSouth() == null) { 
                output =  Color.RED + "There is nothing south of here." + Color.RESET; 
            }
            else if (Map.GetCurrentLocation().GetSouth().GetUnlocked() == false) { 
                output =  "The south door is locked."; 
            }
            else { 
                Map.GetCurrentLocation().SetIsCurrent(false);
                Map.SetCurrentLocation(Map.GetCurrentLocation().GetSouth());
                Map.GetCurrentLocation().SetVisited(true);
                Map.GetCurrentLocation().SetIsCurrent(true);
                output = "You moved south."; 
            }
        }

        else if(direction.equals(_east)){
            if (Map.GetCurrentLocation().GetEast() == null) { 
                output =  Color.RED + "There is nothing east of here." + Color.RESET; 
            }
            else if (Map.GetCurrentLocation().GetEast().GetUnlocked() == false) { 
                output = "The east door is locked."; 
            }
            else { 
                Map.GetCurrentLocation().SetIsCurrent(false);
                Map.SetCurrentLocation(Map.GetCurrentLocation().GetEast());
                Map.GetCurrentLocation().SetVisited(true);
                Map.GetCurrentLocation().SetIsCurrent(true);
                output = "You moved east."; 
            }
        }

        else if(direction.equals(_west)){
            if (Map.GetCurrentLocation().GetWest() == null) { 
                output =  Color.RED + "There is nothing west of here." + Color.RESET; 
            }
            else if (Map.GetCurrentLocation().GetWest().GetUnlocked() == false) { 
                output = "The west door is locked."; 
            }
            else { 
                Map.GetCurrentLocation().SetIsCurrent(false);
                Map.SetCurrentLocation(Map.GetCurrentLocation().GetWest());
                Map.GetCurrentLocation().SetVisited(true);
                Map.GetCurrentLocation().SetIsCurrent(true);
                output = "You moved west.";
            }
        }
        
        else if(direction.equals(_northEast)){
            if (Map.GetCurrentLocation().GetNorthEast() == null) { 
                output =  Color.RED + "There is nothing north east of here." + Color.RESET; 
            }
            else if (Map.GetCurrentLocation().GetNorthEast().GetUnlocked() == false) { 
                output = "The north east door is locked."; 
            }
            else { 
                Map.GetCurrentLocation().SetIsCurrent(false);
                Map.SetCurrentLocation(Map.GetCurrentLocation().GetNorthEast());
                Map.GetCurrentLocation().SetVisited(true);
                Map.GetCurrentLocation().SetIsCurrent(true);
                output = "You moved north east."; 
            }
        }

        else if(direction.equals(_northWest)){
            if (Map.GetCurrentLocation().GetNorthWest() == null) { 
                output =  Color.RED + "There is nothing north west of here." + Color.RESET; 
            }
            else if (Map.GetCurrentLocation().GetNorthWest().GetUnlocked() == false) { 
                output = "The north west door is locked."; 
            }
            else { 
                Map.GetCurrentLocation().SetIsCurrent(false);
                Map.SetCurrentLocation(Map.GetCurrentLocation().GetNorthWest());
                Map.GetCurrentLocation().SetVisited(true);
                Map.GetCurrentLocation().SetIsCurrent(true);
                output = "You moved north west."; 
            }
        }

        else if(direction.equals(_southEast)){
            if (Map.GetCurrentLocation().GetSouthEast() == null) { 
                output =  Color.RED + "There is nothing south east of here." + Color.RESET; 
            }
            else if (Map.GetCurrentLocation().GetSouthEast().GetUnlocked() == false) { 
                output = "The south east door is locked."; 
            }
            else { 
                Map.GetCurrentLocation().SetIsCurrent(false);
                Map.SetCurrentLocation(Map.GetCurrentLocation().GetSouthEast());
                Map.GetCurrentLocation().SetVisited(true);
                Map.GetCurrentLocation().SetIsCurrent(true);
                output = "You moved south east."; 
            }
        }

        else if(direction.equals(_southWest)){
            if (Map.GetCurrentLocation().GetSouthWest() == null) { 
                output =  Color.RED + "There is nothing south west of here." + Color.RESET; 
            }
            else if (Map.GetCurrentLocation().GetSouthWest().GetUnlocked() == false) { 
                output = "The south west door is locked."; 
            }
            else { 
                Map.GetCurrentLocation().SetIsCurrent(false);
                Map.SetCurrentLocation(Map.GetCurrentLocation().GetSouthWest());
                Map.GetCurrentLocation().SetVisited(true);
                Map.GetCurrentLocation().SetIsCurrent(true);
                output = "You moved south west."; 
            }
        }

        else if(direction.equals(_up)){
            if (Map.GetCurrentLocation().GetUp() == null) { 
                output =  Color.RED + "There is nothing above you." + Color.RESET; 
            }
            else if (Map.GetCurrentLocation().GetUp().GetUnlocked() == false) { 
                output = "The door above you is locked."; 
            }
            else { 
                Map.GetCurrentLocation().SetIsCurrent(false);
                Map.SetCurrentLocation(Map.GetCurrentLocation().GetUp());
                Map.GetCurrentLocation().SetVisited(true);
                Map.GetCurrentLocation().SetIsCurrent(true);
                output = "You go up the stairs."; 
            }
        }

        else if(direction.equals(_down)){
            if (Map.GetCurrentLocation().GetDown() == null) { 
                output =  Color.RED + "There is nothing below you." + Color.RESET; 
            }
            else if (Map.GetCurrentLocation().GetDown().GetUnlocked() == false) { 
                output = "The door below you is locked."; 
            }
            else { 
                Map.GetCurrentLocation().SetIsCurrent(false);
                Map.SetCurrentLocation(Map.GetCurrentLocation().GetDown());
                Map.GetCurrentLocation().SetVisited(true);
                Map.GetCurrentLocation().SetIsCurrent(true);
                output = "You go down the stairs."; 
            }
        }

        else {
            output = "You have encountered an error."; 
        }
            return output;
    }

    private static String Unlock()
    {   
        List<Location> aroundYou = new ArrayList<> (
            Arrays.asList (
                Map.GetCurrentLocation().GetNorth(),
                Map.GetCurrentLocation().GetSouth(),
                Map.GetCurrentLocation().GetEast(),
                Map.GetCurrentLocation().GetWest(),
                Map.GetCurrentLocation().GetNorthEast(),
                Map.GetCurrentLocation().GetNorthWest(),
                Map.GetCurrentLocation().GetSouthEast(),
                Map.GetCurrentLocation().GetSouthWest(),
                Map.GetCurrentLocation().GetUp(),
                Map.GetCurrentLocation().GetDown()
            )
        );

        String output = "You have encountered an error.";
        for(Location location : aroundYou){
            if (location != null && location.GetKey() != null){

                String keyName = location.GetKey().GetName();
                Iterator<Item> iterator = Player.GetInventory().iterator();

                while (iterator.hasNext())
                {
                    Item item = iterator.next();
                    String itemName = item.GetName();
                    if (keyName.equals(itemName))
                    {
                        location.SetVisited(true);
                        location.SetUnlocked(true);
                        iterator.remove(); 
                        output =  "You unlocked the door.";
                    }
                }
                if (!output.equals("You unlocked the door.")){
                    output =  "You don't have the key.";
                }
            }
        }
        if (!output.equals("You unlocked the door.") && !output.equals("You don't have the key.")){
            output =  "There is nothing to unlock.";
        }

        return output;
    }
    
    private static String Take() {

        int index = 0;
        List<Tuple<Integer, Item>> items = new ArrayList<>();

        for(Item item : Map.GetCurrentLocation().GetItems()) {
            index++;
            items.add(new Tuple<>(index, item));
        }

        if (items.size() > 0) {
            Integer userInput = Input.SpecificIntegerInput("what would you like to take? Type 0 if you don't want to take anything.", "Please enter a number", items.size(), "Please enter a number between 0 and " + items.size());
            if (Player.GetInventory().size() < 21) {
                if (userInput == 0) {
                    return "You didn't take anything.";
                }
                for(var itemPair : items) {
                    if(userInput == itemPair.getFirst()) {
                        Player.AddToInventory(itemPair.getSecond());
                        Map.GetCurrentLocation().RemoveItem(itemPair.getSecond());
                        return "You took the " + itemPair.getSecond().GetName() + ".";
                    }
                }
                return "You have encountered an error.";
            }
            else {
                return "You have to much stuff in your inventory.";
            }
        }
        else {
            return "You looked around the " + Map.GetCurrentLocation().GetName() + " but you see nothing special.";
        }
    }

    private static String Drop() {

        int index = 0;
        List<Tuple<Integer, Item>> items = new ArrayList<>();

        for(Item item : Player.GetInventory()) {
            index++;
            items.add(new Tuple<>(index, item));
        }

        if (items.size() > 0) {
            Integer userInput = Input.SpecificIntegerInput("what would you like to drop? Type 0 if you don't want to drop anything.", "Please enter a number", items.size(), "Please enter a number between 0 and " + items.size());
            if (Map.GetCurrentLocation().GetItems().size() < 21) {
                if (userInput == 0) {
                    return "You didn't drop anything.";
                }
                for(var itemPair : items) {
                    if(userInput == itemPair.getFirst()) {
                        Player.RemoveFromInventory(itemPair.getSecond());
                        Map.GetCurrentLocation().AddItem(itemPair.getSecond());
                        return "You dropped the " + itemPair.getSecond().GetName() + ".";
                    }
                }
                return "You have encountered an error.";
            }
            else {
                return "This room is to cluttered. You can't drop anything.";
            }
        }
        else {
            return "You don't have anything to drop.";
        }
    }

    private static String Inspect() {

        int index = 0;
        List<Tuple<Integer, Item>> items = new ArrayList<>();

        for(Item item : Player.GetInventory()) {
            index++;
            items.add(new Tuple<>(index, item));
        }

        if (items.size() > 0) {
            Integer userInput = Input.SpecificIntegerInput("what would you like to inspect? Type 0 if you don't want to inspect anything.", "Please enter a number", items.size(), "Please enter a number between 0 and " + items.size());
            if (userInput == 0) {
                return "You didn't inspect anything";
            }
            for(var itemPair : items) {
                if(userInput == itemPair.getFirst()) {
                    Screen.UpdateTitle("You took a closer look at the " + itemPair.getSecond().GetName());
                    Screen.UpdateDescription(itemPair.getSecond().GetDescription());
                    return "You inspected the " + itemPair.getSecond().GetName();
                }
            }
            return "You have encountered an error.";
        }
        else {
            return "You don't have anything in your inventory to inspect";
        }
    }

    private static String Look() {
        //Screen.SetHasLooked(true);
        Screen.UpdateTitle("You are currently in the " + Map.GetCurrentLocation().GetName() + ".");
        Screen.UpdateDescription(Map.GetCurrentLocation().GetDescription2());
        return "You took a look around the " + Map.GetCurrentLocation().GetName() + ".";
    }

    public static String GetNorth() {return _north;}
    public static String GetSouth() {return _south;}
    public static String GetEast() {return _east;}
    public static String GetWest() {return _west;}
    public static String GetNorthEast() {return _northEast;}
    public static String GetNorthWest() {return _northWest;}
    public static String GetSouthEast() {return _southEast;}
    public static String GetSouthWest() {return _southWest;}
    public static String GetUp() {return _up;}
    public static String GetDown() {return _down;}

    public static String GetLook() {return _look;}
    public static String GetInspect() {return _inspect;}
    public static String GetTake() {return _take;}
    public static String GetDrop() {return _drop;}
    public static String GetUnlock() {return _unlock;}
    public static String GetQuit() {return _quit;}
}
