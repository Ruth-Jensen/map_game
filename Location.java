import java.util.ArrayList;
import java.util.List;

public class Location {

    private String _name;
    private String _description1;
    private String _description2;

    private int _floor;
    private Location _north = null;
    private Location _south = null;
    private Location _east = null;
    private Location _west = null;
    private Location _northEast = null;
    private Location _northWest = null;
    private Location _southEast = null;
    private Location _southWest = null;
    private Location _up = null;
    private Location _down = null;
    
    private boolean _visited = false;
    private boolean _isCurrent = false;
    private boolean _unlocked = true;

    private Item _key = null;
    private List<Item> _items = new ArrayList<>();

    public Location (
        String name, 
        String description1, 
        String description2, 
        int floor, 
        boolean visited,
        boolean isCurrent, 
        boolean unlocked, 
        Item key
    ) {
        this._name = name;
        this._description1 = description1;
        this._description2 = description2;
        this._floor = floor;
        this._visited = visited;
        this._isCurrent = isCurrent;
        this._unlocked = unlocked;
        this._key = key;
    }

    public void PopulateLocations (
        Location north, 
        Location south, 
        Location east, 
        Location west, 
        Location northeast, 
        Location northwest, 
        Location southeast, 
        Location southwest, 
        Location up, 
        Location down
    ) {
        this._north = north;
        this._south = south;
        this._east = east;
        this._west = west;
        this._northEast = northeast;
        this._northWest = northwest;
        this._southEast = southeast;
        this._southWest = southwest;
        this._up = up;
        this._down = down;
    }

    public void visitLocation()
    {
        this._visited = true;
        this._unlocked = true;
    }

    public String GetName() {return _name;}
    public String GetDescription1() {return _description1;}
    public String GetDescription2() {return _description2;}
    
    public boolean GetVisited() {return _visited;}
    public void SetVisited(boolean visited) {this._visited = visited;}
    public boolean GetIsCurrent() {return _isCurrent;}
    public void SetIsCurrent(boolean isCurrent) {this._isCurrent = isCurrent;}
    public boolean GetUnlocked() {return _unlocked;}
    public void SetUnlocked(boolean unlocked) {this._unlocked = unlocked;}
    
    public int GetFloor() {return _floor;}
    public Location GetNorth() {return _north;}
    public Location GetSouth() {return _south;}
    public Location GetEast() {return _east;}
    public Location GetWest() {return _west;}
    public Location GetNorthEast() {return _northEast;}
    public Location GetNorthWest() {return _northWest;}
    public Location GetSouthEast() {return _southEast;}
    public Location GetSouthWest() {return _southWest;}
    public Location GetUp() {return _up;}
    public Location GetDown() {return _down;}
    
    public Item GetKey() {return _key;}

    public void AddItem(Item item) { _items.add(item); }
    public List<Item> GetItems() { return _items; }
    public void RemoveItem(Item item) { _items.remove(item); }
}
