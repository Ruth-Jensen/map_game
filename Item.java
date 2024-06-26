public class Item
{
    private String _name;
    private String _description;
    private String _bookText;
    private ItemType _type;
    private boolean _equipped = false;

    public Item (
        String name, 
        String description, 
        String bookText,
        ItemType type
    ) {
        this._name = name;
        this._description = description;
        this._bookText = bookText;
        this._type = type;
    }

    public String GetName() {return _name;}
    public String GetDescription() {return _description;}
    public ItemType GetType() {return _type;}
    
    public boolean GetEquipped() {return _equipped;}
    public void SetEquipped(boolean equipped) {this._equipped = equipped;}
}