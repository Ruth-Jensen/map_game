import java.util.ArrayList;
import java.util.List;

public class Screen {
    
    private static String[] _screen;
    private static Integer _screenWidth = 200;
    private static Integer _screenHeight = 39;
    private static List<String> _Bottom = new ArrayList<>();
    private static List<String> _Top = new ArrayList<>();
    //private static boolean _hasLooked = false;
    private static List<String> compass = new ArrayList<>();
    private static String _title;
    private static String _description;

    static {
        _title = Map.GetCurrentLocation().GetName();
        _description = Map.GetCurrentLocation().GetDescription1();
        _screen = new String[_screenHeight];
        compass.add("_______________________________________");
        compass.add("|                                     |");
        compass.add("|  Move around with:    North: " + Action.GetNorth() + "      |");
        compass.add("|                       South: " + Action.GetSouth() + "      |");
        compass.add("|   " + Action.GetNorthWest() + "   " + Action.GetNorth() + "   " + Action.GetNorthEast() + "      " + Action.GetUp() + "    East: " + Action.GetEast() + "       |");
        compass.add("|     \\ | /       /|\\   West: " + Action.GetWest() + "       |");
        compass.add("|      \\|/         |    NorthEast: " + Action.GetNorthEast() + "  |");
        compass.add("| " + Action.GetWest() + "-----|-----" + Action.GetEast() + "    |    NorthWest: " + Action.GetNorthWest() + "  |");
        compass.add("|      /|\\         |    SouthEast: " + Action.GetSouthEast() + "  |");
        compass.add("|     / | \\       \\|/   SouthWest: " + Action.GetSouthWest() + "  |");
        compass.add("|   " + Action.GetSouthWest() + "   " + Action.GetSouth() + "   " + Action.GetSouthEast() + "      " + Action.GetDown() + "    Up: " + Action.GetUp() + "         |");
        compass.add("|                       Down: " + Action.GetDown() + "       |");
        compass.add("|                                     |");
        compass.add("|  Other actions:                     |");
        compass.add("|                                     |");
        compass.add("|     Look: " + Action.GetLook() + "                         |");
        compass.add("|     Inspect Item: " + Action.GetInspect() + "                 |");
        compass.add("|     Take: " + Action.GetTake() + "                         |");
        compass.add("|     Drop: " + Action.GetDrop() + "                         |");
        compass.add("|     Unlock: " + Action.GetUnlock() + "                       |");
        compass.add("|     Quit: " + Action.GetQuit() + "                         |");
        compass.add("|                                     |");
        compass.add("|                                     |");
        compass.add("|                                     |");
        compass.add("|_____________________________________|");
    }
    
    public static void UpdateScreen() {

        Integer count;
        Integer index = 0;

        // line 1
        _screen[index] = Color.WHITE_BACKGROUND + Color.RED + "=".repeat(_screenWidth) + Color.RESET;
        index++;

        // line 2
        //count = (_screenWidth - (25 + Map.GetCurrentLocation().GetName().length())) / 2;
        count = (_screenWidth - _title.length()) / 2;
        //_screen[index] = " ".repeat(count) + "You are currently in the " + Map.GetCurrentLocation().GetName() + " ".repeat(count);
        _screen[index] = " ".repeat(count) + _title + " ".repeat(count);
        index++;

        // line 3-?
        List<String> locationDescription;
        // if (!_hasLooked) { locationDescription = TextWrap.wrap(Map.GetCurrentLocation().GetDescription1(), _screenWidth); }
        // else { locationDescription = TextWrap.wrap(Map.GetCurrentLocation().GetDescription2(), _screenWidth); }
        locationDescription = TextWrap.wrap(_description, _screenWidth);
        for(String line : locationDescription) {
            _screen[index] = line;
            index++;
        }

        // line 4
        _screen[index] = "=".repeat(_screenWidth);
        index++;

        // line 5-25
        List<String> playerInventory = Screen.BuildPlayerInventory();
        List<String> map = Screen.BuildMap();
        List<String> locationInventory = Screen.BuildLocationInventory();

        count = (_screenWidth - (compass.get(0) + " " + map.get(0) + " " + playerInventory.get(0) + " " + locationInventory.get(0)).length()) / 2;
        for(int i = 0; i < map.size(); i++) {
            _screen[index] = " ".repeat(count) + compass.get(i) + " " + map.get(i) + " " + playerInventory.get(i) + " " + locationInventory.get(i);
            index++;
        }

        // remainder
        Integer fromBottom = _Bottom.size();
        
        _screen[index] = "";
        index++;
        if (_Top.size() > 0) {
            for(int i = 0; i < _Top.size(); i++) {
                count = (_screenWidth - _Top.get(i).length()) / 2;
                _screen[index] = "-".repeat(count - 1) + " " + _Top.get(i) + " " + "-".repeat(count - 1);
                index++;
            }
        }
        else {
            _screen[index] = "-".repeat(_screenWidth);
                index++;
        }

        for(int i = index; i < _screenHeight - fromBottom; i++) {
            _screen[index] = " ";
            index++;
        }

        for(int i = 0; i < fromBottom; i++){
            _screen[index] = _Bottom.get(i);
            index++;
        }

        // print
        try {
            for(int i = 0; i < _screenHeight; i++) {
                if (i == _screenHeight - 1) { System.out.print(_screen[i]); }
                else { System.out.println(_screen[i]); }
            }
        } catch (IndexOutOfBoundsException e) {
            ResetTop();
            AddToTop("You have encountered an error. The screen is too small.");
            ResetBottom();
            UpdateScreen();
        }
        
    }

    public static List<String> BuildPlayerInventory() {
        Integer width = 0;
        Integer index = 0;
        List<String> playerInventory = new ArrayList<>();
        List<Tuple<String, Item>> items = new ArrayList<>();
        
        for(Item item : Player.GetInventory()) {
            index++;
            if(Integer.toString(index).length() < 2) { items.add(new Tuple<>("0" + Integer.toString(index), item)); }
            else{ items.add(new Tuple<>(Integer.toString(index), item)); }
            if(item.GetName().length() > width) { 
                width = item.GetName().length(); 
            }
        }
        width += 13;
        if(width < 24) { width = 24; }

        playerInventory.add("_".repeat(width));
        playerInventory.add("|" + " ".repeat(width - 2) + "|");
        playerInventory.add("|  " + "Player Inventory:" + " ".repeat(width - 24) + "   |");
        Integer count = 4;
        for(var itemPair : items) {
            String itemString = "|     " + itemPair.getFirst() + ". " + itemPair.getSecond().GetName();
            playerInventory.add(itemString + " ".repeat(width - itemString.length() - 2) + " |");
            count++;
        }
        count = 25 - count;
        for(int i = 0; i < count; i++) {
            playerInventory.add("|" + " ".repeat(width - 2) + "|");
        }
        playerInventory.add("|" + "_".repeat(width - 2) + "|");

        return playerInventory;
    }

    public static List<String> BuildLocationInventory() {
        Integer minWidth = 18 + Map.GetCurrentLocation().GetName().length();
        Integer width = 0;
        Integer index = 0;
        List<String> LocationInventory = new ArrayList<>();
        List<Tuple<String, Item>> items = new ArrayList<>();
        
        for(Item item : Map.GetCurrentLocation().GetItems()) {
            index++;
            if(Integer.toString(index).length() < 2) { items.add(new Tuple<>("0" + Integer.toString(index), item)); }
            else{ items.add(new Tuple<>(Integer.toString(index), item)); }
            if(item.GetName().length() > width) { 
                width = item.GetName().length(); 
            }
        }
        width += 13;
        if(width < minWidth) { width = minWidth; }

        LocationInventory.add("_".repeat(width));
        LocationInventory.add("|" + " ".repeat(width - 2) + "|");
        LocationInventory.add("|  " + Map.GetCurrentLocation().GetName() +" Inventory:" + " ".repeat(width - minWidth) + "   |");
        Integer count = 4;
        for(var itemPair : items) {
            String itemString = "|     " + itemPair.getFirst() + ". " + itemPair.getSecond().GetName();
            LocationInventory.add(itemString + " ".repeat(width - itemString.length() - 2) + " |");
            count++;
        }
        count = 25 - count;
        for(int i = 0; i < count; i++) {
            LocationInventory.add("|" + " ".repeat(width - 2) + "|");
        }
        LocationInventory.add("|" + "_".repeat(width - 2) + "|");

        // for(String line : LocationInventory) {
        //     System.out.println(line);
        // }

        return LocationInventory;
    }

    public static List<String> BuildMap(){

        int floor = Map.GetCurrentLocation().GetFloor();
        List<String> map = new ArrayList<>();

        if (floor == 0){
            List<String> floorMap = Map.UpdateBasementMap();
            map.add("_____________________________________________________________________");
            map.add("|                                                                   |");
            map.add("|                                                                   |");
            map.add("|                                                                   |");
            for(String line : floorMap){
                map.add("|              " + Map.GetMapColor() + line + Color.RESET + "               |");
            }
            map.add("|                                                                   |");
            map.add("|                                                                   |");
            map.add("|                                                                   |");
            map.add("|___________________________________________________________________|");
        }
        else if (floor == 1){
            List<String> floorMap = Map.UpdateGroundFloorMap();
            map.add("_____________________________________________________________________");
            for(String line : floorMap){
                map.add("|  " + Map.GetMapColor() + line + Color.RESET + "  |");
            }
            map.add("|___________________________________________________________________|");
        }
        else if (floor == 2){
            List<String> floorMap = Map.UpdateSecondFloorMap();
            map.add("_____________________________________________________________________");
            map.add("|                                                                   |");
            map.add("|                                                                   |");
            for(String line : floorMap){
                map.add("|  " + Map.GetMapColor() + line + Color.RESET + "  |");
            }
            map.add("|                                                                   |");
            map.add("|                                                                   |");
            map.add("|                                                                   |");
            map.add("|___________________________________________________________________|");
        }
        else{
            map.add("couldn't find floor map");
        }
        return map;
    }

    // public static void SetHasLooked(boolean hasLooked) {
    //     _hasLooked = hasLooked;
    //     UpdateScreen();
    // }

    public static void AddToTop(String line) {
        _Top.add(line);
        UpdateScreen();
    }

    public static void AddToBottom(String line) {
        _Bottom.add(line);
        UpdateScreen();
    }

    public static void RemoveFromTop(String line) {
        _Top.remove(line);
        UpdateScreen();
    }

    public static void RemoveFromBottom(String line) {
        _Bottom.remove(line);
        UpdateScreen();
    }

    public static void ResetTop() {
        _Top = new ArrayList<>();
        UpdateScreen();
    }

    public static void ResetBottom() {
        _Bottom = new ArrayList<>();
        UpdateScreen();
    }

    public static void UpdateTitle(String title) {
        _title = title;
        UpdateScreen();
    }

    public static void UpdateDescription(String description) {
        _description = description;
        UpdateScreen();
    }
}



/*
"________________________"01
"|                      |"02
"|  Player Inventory:   |"03
"|     01. Secret Room  |"04
"|     02.              |"05
"|     03.              |"06
"|     04.              |"07
"|     05.              |"08
"|     06.              |"09
"|     07.              |"10
"|     08.              |"11
"|     09.              |"12
"|     10.              |"13
"|     11.              |"14
"|     12.              |"15
"|     13.              |"16
"|     14.              |"17
"|     15.              |"18
"|     16.              |"19
"|     17.              |"20
"|     18.              |"21
"|     19.              |"22
"|     20.              |"23
"|     21.              |"24
"|______________________|"25
*/

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