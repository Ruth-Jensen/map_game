import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Map
{
    private static Location _courtyard;
    
    private static Location _currentLocation;

    // Second Floor
    private static List<Location> _secondFloor;
    private static Location _library;
    private static Location _arcanum;
    private static Location _observatory;
    private static Location _alchemyLab;
    private static Location _balconyGarden;

    // Ground Floor
    private static List<Location> _groundFloor;
    private static Location _frontEntrance;
    private static Location _servantQuarters;
    private static Location _ballRoom;
    private static Location _diningRoom;
    private static Location _kitchen;
    private static Location _westWing;
    private static Location _hall;
    private static Location _eastWing;
    private static Location _guestRoom1;
    private static Location _guestRoom2;
    private static Location _guestRoom3;

    // Basement
    private static List<Location> _basement;
    private static Location _cellar;
    private static Location _storageRoom;
    private static Location _secretChamber;

    private static String mapColor = Color.PURPLE;
    private static String playerColor = Color.YELLOW_BOLD;

    static {
        
        //Library
        Item mysteriousJournal = new Item("Mysterious Journal", "An old journal filled with cryptic notes and symbols.", "Beware the path that lies ahead...", ItemType.QUEST_ITEM);
        Item Runestone = new Item("Runestone", "A stone inscribed with ancient runes, glowing faintly.", "Power lies within the one who understands...", ItemType.QUEST_ITEM);
        Item oldMap = new Item("Old Map", "A worn map detailing forgotten paths and hidden locations.", "", ItemType.OTHER);
        Item dustyScrolls = new Item("Dusty Scrolls", "A stack of scrolls covered in dust, containing ancient texts.", "In the heart of darkness, light shall guide...", ItemType.OTHER);
        Item ornateBookends = new Item("Ornate Bookends", "Beautifully crafted bookends depicting mythical creatures.", "", ItemType.OTHER);
        Item ancientTome = new Item("Ancient Tome", "A heavy book bound in leather, filled with archaic knowledge.", "The secrets of the ancients are buried deep...", ItemType.OTHER);
        Item magnifyingGlass = new Item("Magnifying Glass", "A tool for examining small details, with a brass handle.", "", ItemType.OTHER);

        //Arcanum
        Item crystalBall = new Item("Crystal Ball", "A clear orb used for divination and seeing the unseen.", "", ItemType.OTHER);
        Item potionIngredients = new Item("Potion Ingredients", "A collection of rare and mystical ingredients for brewing potions.", "", ItemType.OTHER);
        Item oldManuscripts = new Item("Old Manuscripts", "Ancient documents detailing forgotten spells and rituals.", "By the light of the moon, power is granted...", ItemType.OTHER);
        Item brokenWand = new Item("Broken Wand", "A once powerful wand, now snapped in half.", "", ItemType.OTHER);
        Item tarotCards = new Item("Tarot Cards", "A deck of cards used for fortune-telling and mystical insights.", "", ItemType.OTHER);

        //Observatory
        Item starChart = new Item("Star Chart", "A detailed map of the stars and constellations.", "", ItemType.OTHER);
        Item telescope = new Item("Telescope", "A device for observing distant celestial bodies.", "", ItemType.OTHER);
        Item astronomersJournal = new Item("Astronomers Journal", "Notes and sketches of celestial observations.", "The stars align to reveal the path ahead...", ItemType.OTHER);
        Item antiqueGlobe = new Item("Antique Globe", "A vintage globe showing the world's geography.", "", ItemType.OTHER);
        Item celestialMaps = new Item("Celestial Maps", "Maps depicting the positions of stars and planets.", "", ItemType.OTHER);

        //Alchemy Lab
        Item mortarAndPestle = new Item("Mortar and Pestle", "Tools for grinding herbs and other ingredients.", "", ItemType.QUEST_ITEM);
        Item ancientHerbs = new Item("Ancient Herbs", "Rare herbs with powerful properties.", "", ItemType.QUEST_ITEM);
        Item crystalFlask = new Item("Crystal Flask", "A flask made of crystal, used for storing potions.", "", ItemType.QUEST_ITEM);
        Item bottlesOfElixirs = new Item("Bottles of Elixirs", "Various bottles filled with colorful liquids.", "", ItemType.OTHER);
        Item unlabeledVials = new Item("Unlabeled Vials", "Small vials containing unknown substances.", "", ItemType.OTHER);
        Item alchemistsJournal = new Item("Alchemists Journal", "A journal filled with alchemical recipes and experiments.", "Combine the elements to unlock the secrets of transmutation...", ItemType.OTHER);
        Item alchemicalCauldron = new Item("Alchemical Cauldron", "A large cauldron used for brewing potions.", "", ItemType.OTHER);

        //Balcony Garden
        Item rareHerbs = new Item("Rare Herbs", "Exotic herbs used in various potions and remedies.", "", ItemType.QUEST_ITEM);
        Item gardeningTools = new Item("Gardening Tools", "Tools for maintaining the garden.", "", ItemType.OTHER);
        Item pottedPlants = new Item("Potted Plants", "Various plants in decorative pots.", "", ItemType.OTHER);
        Item wateringCan = new Item("Watering Can", "A can for watering plants.", "", ItemType.OTHER);

        //Front Entrance
        Item ornateUmbrellaStand = new Item("Ornate Umbrella Stand", "A decorative stand for holding umbrellas.", "", ItemType.OTHER);
        Item visitorsLog = new Item("Visitors Log", "A book where guests sign in upon arrival.", "Welcome, traveler. May your stay be peaceful and your journey fruitful...", ItemType.OTHER);
        Item coatRack = new Item("Coat Rack", "A rack for hanging coats and hats.", "", ItemType.OTHER);

        //Servant Quarters
        Item laundryBasket = new Item("Laundry Basket", "A basket for holding dirty laundry.", "", ItemType.OTHER);
        Item broom = new Item("Broom", "A broom for sweeping the floors.", "", ItemType.OTHER);
        Item sewingKit = new Item("Sewing Kit", "A kit containing needles, thread, and other sewing supplies.", "", ItemType.OTHER);

        //Ballroom
        Item revealingPotion = new Item("Revealing Potion", "A potion that reveals hidden truths.", "To uncover what is concealed, drink this potion...", ItemType.QUEST_ITEM);
        Item antiqueMusicBox = new Item("Antique Music Box", "A small box that plays a charming tune when opened.", "", ItemType.OTHER);
        Item chandelierCrystals = new Item("Chandelier Crystals", "Crystals from a grand chandelier, reflecting light beautifully.", "", ItemType.OTHER);
        Item danceShoes = new Item("Dance Shoes", "Elegant shoes worn for dancing.", "", ItemType.OTHER);
        Item gildedMirror = new Item("Gilded Mirror", "A mirror with an ornate, gold frame.", "", ItemType.OTHER);

        //Dining Room
        Item silverwareSet = new Item("Silverware Set", "A set of finely crafted silver utensils.", "", ItemType.OTHER);
        Item fineChina = new Item("Fine China", "Delicate china plates and cups.", "", ItemType.OTHER);
        Item crystalDecanter = new Item("Crystal Decanter", "A decanter made of crystal, used for serving drinks.", "", ItemType.OTHER);
        Item linenNapkins = new Item("Linen Napkins", "High-quality linen napkins.", "", ItemType.OTHER);

        //Kitchen
        Item chefsKnife = new Item("Chef's Knife", "A sharp knife used for preparing food.", "", ItemType.OTHER);
        Item spiceRack = new Item("Spice Rack", "A rack holding a variety of spices.", "", ItemType.OTHER);
        Item cuttingBoard = new Item("Cutting Board", "A board used for chopping ingredients.", "", ItemType.OTHER);
        Item rollingPin = new Item("Rolling Pin", "A tool for rolling out dough.", "", ItemType.OTHER);

        //West Wing
        Item crystalWand = new Item("Crystal Wand", "A wand made of crystal, radiating magical energy.", "", ItemType.QUEST_ITEM);
        Item portraitOfAnAncestor = new Item("Portrait of an Ancestor", "A painting of a distinguished family member.", "", ItemType.OTHER);
        Item decorativeVase = new Item("Decorative Vase", "An intricately designed vase.", "", ItemType.OTHER);
        Item oldClock = new Item("Old Clock", "A vintage clock, still ticking.", "Time waits for no one...", ItemType.OTHER);
        Item framedLetters = new Item("Framed Letters", "Letters of historical significance, framed for display.", "My dearest, the days grow longer without you...", ItemType.OTHER);
        Item sword = new Item("Sword", "An old but well-maintained sword.", "", ItemType.OTHER);

        //Hall
        Item candleHolder = new Item("Candle Holder", "A holder for candles, made of brass.", "", ItemType.OTHER);
        Item umbrella = new Item("Umbrella", "A sturdy umbrella for rainy days.", "", ItemType.OTHER);
        Item walkingCane = new Item("Walking Cane", "An elegant cane for support while walking.", "", ItemType.OTHER);

        //East Wing
        Item secretChamberKey = new Item("Secret Room Key", "A key that opens a hidden chamber.", "The key has an inscription in an unknown language.", ItemType.KEY);
        Item familyCrest = new Item("Family Crest", "An emblem representing the family heritage.", "Honor and Glory...", ItemType.OTHER);
        Item lockedBox = new Item("Locked Box", "A small box that is securely locked.", "", ItemType.OTHER);
        Item decorativePlates = new Item("Decorative Plates", "Beautifully designed plates for display.", "", ItemType.OTHER);
        Item antiqueMirror = new Item("Antique Mirror", "An old mirror with a tarnished frame.", "Reflect upon your past...", ItemType.OTHER);

        //Guest Room 1
        Item travelDiary = new Item("Travel Diary", "A diary filled with notes from various travels.", "Today I arrived in a strange new land...", ItemType.OTHER);
        Item suitcase = new Item("Suitcase", "A large suitcase for carrying clothes and other items.", "", ItemType.OTHER);
        Item vanitySet = new Item("Vanity Set", "A set of items for personal grooming.", "", ItemType.OTHER);

        //Guest Room 2
        Item writingDesk = new Item("Writing Desk", "A desk for writing and working.", "", ItemType.OTHER);
        Item decorativePillow = new Item("Decorative Pillow", "A pillow with intricate designs.", "", ItemType.OTHER);

        //Guest Room 3
        Item comfyChair = new Item("Comfy Chair", "A plush chair for relaxing.", "", ItemType.OTHER);
        Item blanket = new Item("Blanket", "A warm blanket for comfort.", "", ItemType.OTHER);

        //Cellar
        Item hiddenCompartment = new Item("Hidden Compartment", "A secret compartment for hiding valuable items.", "", ItemType.OTHER);
        Item BarrelOfRum = new Item("Barrel of Rum", "A large barrel filled with rum.", "", ItemType.OTHER);
        Item oldTools = new Item("Old Tools", "A set of worn-out tools.", "", ItemType.OTHER);
        Item wineBottle = new Item("Wine Bottle", "A bottle of fine wine.", "The label reads, 'Vintage 1890...'", ItemType.OTHER);
        Item barrel = new Item("Barrel", "A standard barrel for storage.", "", ItemType.OTHER);
        Item crate = new Item("Crate", "A wooden crate for transporting goods.", "", ItemType.OTHER);

        //Storage Room
        Item rope = new Item("Rope", "A long, sturdy rope.", "", ItemType.OTHER);
        Item dustyBoxes = new Item("Dusty Boxes", "Boxes covered in a thick layer of dust.", "", ItemType.OTHER);
        Item brokenFurniture = new Item("Broken Furniture", "Pieces of furniture that are broken and unusable.", "", ItemType.OTHER);
        Item oldPaintings = new Item("Old Paintings", "Paintings that are old and faded.", "", ItemType.OTHER);

        //Secret Chamber
        Item courtyardKey = new Item("Courtyard Key", "A key that grants access to the courtyard.", "", ItemType.KEY);
        Item ancientRelic = new Item("Ancient Relic", "A mysterious and powerful artifact from ancient times.", "The inscriptions on the relic are in an unknown language.", ItemType.QUEST_ITEM);
        Item codedManuscript = new Item("Coded Manuscript", "A manuscript written in an unknown code.", "", ItemType.QUEST_ITEM);
        Item mysteriousAmulet = new Item("Mysterious Amulet", "An amulet with an unknown origin and purpose.", "", ItemType.OTHER);
        Item oldChest = new Item("Old Chest", "A wooden chest that looks very old.", "", ItemType.OTHER);



        _courtyard = new Location(
            "Courtyard", 
            "",
            "",
            1, 
            false, 
            false,
            false, 
            courtyardKey
        );

        // Second Floor Locations
        _library = new Location(
            "Library", 
            "A spacious room filled with rows of bookshelves. Sunlight filters in through tall windows, illuminating the dusty tomes and ancient manuscripts.", 
            "As you take a closer look, the room's grandeur unfolds. The mahogany bookshelves, intricately carved, tower from floor to ceiling, packed with books of varying ages. The scent of aged paper and leather fills the air. Sunlight streams through tall, arched windows, casting a golden glow and revealing dust motes dancing lazily. A large, ornate wooden table holds ancient manuscripts, open and inviting. In one corner, a grand fireplace boasts a carved mantle with mythical scenes. One book lies slightly askew, as if hastily replaced, and a faint draft hints at a hidden passage.",
            2, 
            false, 
            false,
            true, 
            null
        );
        _arcanum = new Location(
            "Arcanum", 
            "An enigmatic chamber adorned with arcane symbols and mysterious artifacts. The air crackles with latent magic, and the room seems to pulse with hidden energy.",
            "As you take a closer look, the chamber's mysteries deepen. The walls are adorned with intricate arcane symbols, glowing faintly. Shelves and pedestals display curious artifacts, each radiating an aura of magic. The air crackles with latent energy, making your skin tingle. In the center, a large, ancient tome lies open on a pedestal, its pages filled with cryptic runes. A strange, pulsating glow emanates from a corner of the room, drawing your attention. One symbol on the wall flickers erratically, as if hiding a secret. The room pulses with hidden energy, beckoning further exploration.",
            2, 
            false, 
            false,
            true, 
            null
        );
        _observatory = new Location(
            "Observatory", 
            "A domed chamber with a towering telescope at its center. Through the telescope, you can see distant galaxies and celestial bodies, capturing the wonder of the cosmos.", 
            "As you take a closer look, the chamber's wonders unfold. The polished brass telescope towers at the center, directed towards the heavens. Through its lens, distant galaxies and celestial bodies come into view, each one capturing the awe of the cosmos. The curved walls are adorned with star charts and intricate astronomical instruments. A gentle hum emanates from the telescope, suggesting sophisticated mechanisms at work. A handheld telescope rests on a nearby table. The room resonates with the thrill of infinite exploration and celestial mystery.", 
            2, 
            false, 
            false, 
            true, 
            null
        );
        _alchemyLab = new Location(
            "Alchemy Lab", 
            "A cluttered workspace littered with vials, beakers, and bubbling concoctions. The air is thick with the scent of potions and elixirs, hinting at the alchemist's experiments.", 
            "As you take a closer look, the cluttered workspace reveals more details. The table is strewn with vials, beakers, and bubbling concoctions, some emitting faint, colorful vapors. The air is thick with the pungent scent of potions and elixirs, hinting at the alchemist's experiments. Shelves along the walls are packed with jars of mysterious ingredients, labeled in a spidery script. An open book, filled with handwritten notes and diagrams, lies on a stand. One flask glows with an eerie light, its contents swirling mysteriously. The room buzzes with the energy of ongoing alchemical discoveries.",
            2, 
            false, 
            false,
            true, 
            null
        );
        _balconyGarden = new Location(
            "Balcony Garden", 
            "A tranquil oasis nestled amidst the stone walls of the castle. Fragrant flowers bloom in profusion, and lush greenery spills over the balustrades, offering a serene retreat.", 
            "As you take a closer look, the oasis's tranquility deepens. Nestled amidst the stone walls of the castle, the garden overflows with fragrant flowers in full bloom. Lush greenery cascades over the balustrades, creating a serene retreat. A gentle breeze carries the sweet scent of blossoms, mingling with the earthy aroma of rich soil. Birds chirp softly, flitting between branches. A stone bench, partially hidden by ivy, invites you to sit and soak in the peaceful surroundings. The air is filled with the soft rustle of leaves and the distant murmur of a hidden fountain.", 
            2, 
            false, 
            false, 
            true, 
            null
        );

        // Ground Floor Locations

        _frontEntrance = new Location(
            "Front Entrance", 
            "A grand foyer with sweeping staircases and opulent furnishings. The air is heavy with the scent of polished wood and fresh flowers, welcoming visitors to the mansion.", 
            "As you take a closer look, the grand foyer's opulence becomes more apparent. Sweeping staircases curve gracefully upwards, adorned with ornate railings. The air is heavy with the rich scent of polished wood and fresh flowers, arranged in elegant vases on mahogany tables. Luxurious rugs cover the marble floor, and chandeliers cast a warm, inviting glow. Intricate tapestries and fine art line the walls, adding to the sense of grandeur. A large, gilded mirror reflects the lavish surroundings, enhancing the welcoming atmosphere of the mansion.", 
            1, 
            true, 
            true,
            true, 
            null
        );
        _servantQuarters = new Location(
            "Servant Quarters", 
            "A utilitarian space where the servants of the mansion live and work. Simple furnishings and narrow beds characterize this humble abode.", 
            "As you take a closer look, the utilitarian nature of the space becomes clear. The servants' quarters are plainly furnished, with narrow beds neatly arranged along the walls. Simple wooden tables and chairs provide functional workspaces, and the few decorations are modest and practical. The air carries a faint scent of soap and clean linen, indicative of ongoing chores. Shelves hold well-worn tools and supplies, essential for the daily upkeep of the mansion. Despite its simplicity, the room exudes a sense of quiet diligence and hard work, reflecting the lives of those who live and labor here.", 
            1, 
            false, 
            false, 
            true, 
            null
        );
        _ballRoom = new Location(
            "Ball Room", 
            "An extravagant chamber adorned with crystal chandeliers and mirrored walls. The polished marble floor invites guests to dance the night away in elegant splendor.", 
            "As you take a closer look, the chamber's extravagance dazzles you. Crystal chandeliers hang from the ceiling, casting sparkling light across the room. Mirrored walls reflect the opulence, creating an illusion of endless space. The polished marble floor, pristine and gleaming, invites guests to dance the night away in elegant splendor. Rich draperies frame the tall windows, and sumptuous furniture is arranged for comfort and conversation. The air is filled with a faint, sweet fragrance, adding to the enchanting atmosphere of this magnificent ballroom.",
            1, 
            false, 
            false, 
            true, 
            null
        );
        _diningRoom = new Location(
            "Dining Room", 
            "A stately hall furnished with a long, mahogany table and plush chairs. The room exudes an aura of refinement, promising sumptuous feasts and lively conversation.", 
            "As you take a closer look, the hall's stateliness becomes more evident. A long, mahogany table dominates the room, its polished surface reflecting the soft light from ornate chandeliers above. Plush chairs, upholstered in rich fabric, are arranged around the table, inviting guests to sit and engage. The walls are adorned with fine tapestries and portraits, adding to the aura of refinement. The air carries a subtle scent of wood polish and fresh flowers, hinting at sumptuous feasts and lively conversation. The room exudes an inviting warmth, promising memorable gatherings.",
            1, 
            false, 
            false, 
            true, 
            null
        );
        _kitchen = new Location(
            "Kitchen", 
            "A spacious room with cold, stainless steel surfaces and cupboards lining the walls. Normally a bustling hub of culinary activity, the room now rests in peaceful silence.", 
            "As you take a closer look, the room's quietness suggests a recent flurry of activity. The cold, stainless steel surfaces are spotless, reflecting the overhead lights with an almost clinical precision. Cupboards are neatly closed, their contents carefully organized. Normally a bustling hub of culinary activity, the kitchen now rests in serene silence. The large, industrial stove is clean and ready for the next meal, and the air carries faint traces of delicious aromas. A neatly folded apron hangs on a hook, and a single utensil lies drying on the counter. The kitchen feels tranquil, as if awaiting the dawn of a new day.",
            1, 
            false, 
            false, 
            true, 
            null
        );
        _westWing = new Location(
            "West Wing", 
            "A grand chamber adorned with rows of polished trophies and mounted heads of exotic creatures. The walls are lined with accolades and mementos of past triumphs, each item a testament to the mansion's rich history.", 
            "As you take a closer look, the grandeur of the chamber becomes more vivid. Polished trophies gleam in neat rows, each a testament to remarkable achievements. Mounted heads of exotic creatures add a touch of wild adventure, their glass eyes reflecting the ambient light. The walls are adorned with accolades and mementos, each piece narrating a tale of past triumphs. Every item is a testament to the mansion's rich history, exuding an air of pride and accomplishment. The room feels alive with stories of bravery and success, creating a palpable sense of honor and legacy.",
            1, 
            false, 
            false, 
            true, 
            null
        );
        _hall = new Location(
            "Hall", 
            "A spacious corridor that connects various rooms and wings of the mansion. Portraits of esteemed ancestors line the walls, their watchful gaze overseeing the comings and goings of guests.", 
            "As you take a closer look, you notice the meticulous attention to detail in the portraits adorning the walls. Each brushstroke seems to capture the essence of the subject, from the stern patriarchs to the graceful matriarchs, instilling the corridor with a sense of familial pride. The frames, though ornate, show signs of careful restoration, preserving the legacy of generations past. Light from the sconces plays upon the gilded edges, casting soft shadows that dance across the corridor's polished surface. It's a gallery of ancestry, a silent testament to the mansion's esteemed lineage.",
            1, 
            false, 
            false, 
            true, 
            null
        );
        _eastWing = new Location(
            "East Wing", 
            "A luxurious suite reserved for the master of the manor. The rooms are tastefully decorated with rich fabrics and fine furnishings, reflecting the refined taste of their absent occupant.", 
            "As you take a closer look, you observe the lavishness of the master suite. Tastefully decorated with rich fabrics and fine furnishings, the rooms exude an air of opulence befitting their esteemed occupant. The bed, draped in sumptuous silk, stands as the focal point of the bedroom, adorned with intricately embroidered pillows. A mahogany writing desk sits in one corner, its surface gleaming under the soft glow of an antique lamp. The sitting area features plush armchairs and a velvet chaise lounge, inviting relaxation and contemplation. Every detail, from the handcrafted rugs to the exquisite artwork on the walls, reflects the refined taste and discerning eye of the absent master. It's a sanctuary of luxury and sophistication, awaiting the return of its owner.",
            1, 
            false, 
            false, 
            true, 
            null
        );
        _guestRoom1 = new Location(
            "Guest Room 1", 
            "A cozy chamber with a four-poster bed and a fireplace. Soft candlelight flickers against the walls, creating a warm and inviting ambiance.", 
            "As you take a closer look, you notice the cozy charm of the chamber. A four-poster bed, draped in soft, flowing curtains, dominates the room, promising comfort and tranquility. Nearby, a fireplace crackles gently, its flames casting a dancing light that mingles with the soft glow of flickering candles. The walls are bathed in a warm, inviting ambiance, creating an atmosphere of serene relaxation. Plush rugs and comfortable armchairs add to the room's intimate feel, making it a perfect retreat for rest and reflection.", 
            1, 
            false, 
            false, 
            true, 
            null
        );
        _guestRoom2 =  new Location(
            "Guest Room 2", 
            "An airy room with large windows overlooking the mansion's gardens. The decor is tasteful, with floral motifs and comfortable seating arrangements.", 
            "As you take a closer look, you notice the airy elegance of the room. Large windows offer stunning views of the mansion's gardens, allowing natural light to flood the space. The decor is tasteful, featuring delicate floral motifs that complement the serene outdoor scenery. A comfortable bed, adorned with soft linens and decorative pillows, sits against one wall, inviting rest. The seating arrangements, including plush armchairs and a cozy settee, enhance the room's relaxation appeal. Soft drapes frame the windows, and the subtle fragrance of fresh flowers enhances the tranquil ambiance. It's a perfect blend of nature and refinement, creating a welcoming and peaceful retreat.",
            1, 
            false, 
            false, 
            true, 
            null
        );
        _guestRoom3 =  new Location(
            "Guest Room 3", 
            "A charming suite with a sitting area and a private balcony. The room is decorated in soft pastel hues, evoking a sense of tranquility and relaxation.", 
            "As you take a closer look, the charming suite reveals its tranquil elegance. A cozy sitting area with plush chairs and a small table invites leisurely moments, while large doors open to a private balcony overlooking the gardens. A comfortable bed, adorned with soft linens and decorative pillows, sits invitingly against one wall. The decor, in soft pastel hues, creates a soothing atmosphere that encourages relaxation. Delicate drapes, tasteful artwork, and fresh flowers add to the room's serene ambiance. The gentle color palette and comfortable furnishings make this suite a perfect retreat, evoking a sense of peace and quiet luxury.", 
            1, 
            false, 
            false, 
            true, 
            null
        );
        
        // Basement Locations
        _cellar = new Location(
            "Cellar", 
            "A dimly lit storage space lined with rows of wooden crates and barrels. Dusty cobwebs cling to the rafters, casting eerie shadows in the flickering candlelight.", 
            "As you take a closer look, the dimly lit storage space reveals its secrets. Rows of wooden crates and barrels line the walls, their surfaces worn and aged. Dusty cobwebs cling to the rafters, casting eerie shadows in the flickering candlelight. The air is thick with the scent of old wood and the faint mustiness of long-forgotten items. Shadows dance across the room, creating an atmosphere of quiet mystery. This storeroom, with its hidden corners and aged contents, feels like a place where forgotten stories and secrets reside, waiting to be uncovered.",
            0, 
            false, 
            false, 
            true, 
            null
        );
        _storageRoom = new Location(
            "Storage Room", 
            "A cluttered chamber filled with assorted odds and ends. Boxes of old trinkets and forgotten treasures are stacked haphazardly, waiting to be rediscovered.", 
            "As you take a closer look, the cluttered storage room reveals a wealth of forgotten items. Assorted odds and ends fill the space, creating a chaotic yet intriguing atmosphere. Boxes of old trinkets and forgotten treasures are stacked haphazardly, waiting to be rediscovered. Dusty surfaces and cobwebs hint at long neglect, while flickers of light catch on metal and glass, revealing glimpses of hidden gems. The air is thick with the scent of aged wood and old paper. Amidst the clutter, one wall seems oddly pristine, its alignment slightly off, suggesting it might hold more than it appears. This room, though disorganized, holds a promise of untold stories and valuable finds, inviting you to delve into its depths.",
            0, 
            false, 
            false, 
            true, 
            null
        );
        _secretChamber = new Location(
            "Secret Chamber", 
            "A hidden alcove concealed behind a false wall. Within its confines lie ancient artifacts and arcane relics, shrouded in mystery and intrigue. In the ceiling you can make out the outline of a trapdoor.", 
            "As you explore the hidden chamber concealed behind the false wall, you are greeted by the sight of ancient artifacts and arcane relics, their presence shrouded in mystery and intrigue. The air carries a faint hint of mustiness, reminiscent of ages past. Illuminated by a soft glow filtering in through the cracks in the wall, the room exudes an aura of secrecy and hidden knowledge. Your gaze shifts upward, where the outline of a trapdoor is discernible in the ceiling, hinting at further depths of secrecy waiting to be unveiled. This clandestine sanctuary, concealed behind the false wall, pulsates with the allure of adventure and the allure of the unknown.", 
            0, 
            false, 
            false, 
            false, 
            secretChamberKey
        );
        
        // Populate Second Floor Locations
        _library.PopulateLocations(null, _observatory, null, null, null, null, null, null, null, null);
        _arcanum.PopulateLocations(null, null, _observatory, null, null, null, null, null, null, _westWing);
        _observatory.PopulateLocations(_library, _balconyGarden, _alchemyLab, _arcanum, null, null, null, null, null, null);
        _alchemyLab.PopulateLocations(null, null, null, _observatory, null, null, null, null, null, _eastWing);
        _balconyGarden.PopulateLocations(_observatory, null, null, null, null, null, null, null, null, null);

        // Populate Ground Floor Locations
        _courtyard.PopulateLocations(null, _diningRoom, _servantQuarters, _frontEntrance, null, null, null, null, null, null);
        _frontEntrance.PopulateLocations(null, _ballRoom, _courtyard, null, null, null, null, null, null, null);
        _servantQuarters.PopulateLocations(null, _kitchen, null, _courtyard, null, null, null, null, null, _cellar);
        _ballRoom.PopulateLocations(_frontEntrance, _westWing, _diningRoom, null, null, null, _hall, null, null, null);
        _diningRoom.PopulateLocations(_courtyard, _hall, _kitchen, _ballRoom, null, null, null, null, null, _secretChamber);
        _kitchen.PopulateLocations(_servantQuarters, _eastWing, null, _diningRoom, null, null, null, _hall, null, null);
        _westWing.PopulateLocations(_ballRoom, null, _hall, null, null, null, null, null, _arcanum, null);
        _hall.PopulateLocations(_diningRoom, _guestRoom2, _eastWing, _westWing, _kitchen, _ballRoom, _guestRoom3, _guestRoom1, null, null);
        _eastWing.PopulateLocations(_kitchen, null, null, _hall, null, null, null, null, _alchemyLab, null);
        _guestRoom1.PopulateLocations(null, null, null, null, _hall, null, null, null, null, null);
        _guestRoom2.PopulateLocations(_hall, null, null, null, null, null, null, null, null, null);
        _guestRoom3.PopulateLocations(null, null, null, null, null, _hall, null, null, null, null);

        // Populate Basement Locations
        _cellar.PopulateLocations(null, _storageRoom, null, null, null, null, null, null, _servantQuarters, null);
        _storageRoom.PopulateLocations(_cellar, null, null, _secretChamber, null, null, null, null, null, null);
        _secretChamber.PopulateLocations(null, null, _storageRoom, null, null, null, null, null, _diningRoom, null);

        // Add Items
        _library.AddItem(mysteriousJournal);
        _library.AddItem(Runestone);
        _library.AddItem(oldMap);
        _library.AddItem(dustyScrolls);
        _library.AddItem(ornateBookends);
        _library.AddItem(ancientTome);
        _library.AddItem(magnifyingGlass);

        _arcanum.AddItem(crystalBall);
        _arcanum.AddItem(potionIngredients);
        _arcanum.AddItem(oldManuscripts);
        _arcanum.AddItem(brokenWand);
        _arcanum.AddItem(tarotCards);

        _observatory.AddItem(starChart);
        _observatory.AddItem(telescope);
        _observatory.AddItem(astronomersJournal);
        _observatory.AddItem(antiqueGlobe);
        _observatory.AddItem(celestialMaps);

        _alchemyLab.AddItem(mortarAndPestle);
        _alchemyLab.AddItem(ancientHerbs);
        _alchemyLab.AddItem(crystalFlask);
        _alchemyLab.AddItem(bottlesOfElixirs);
        _alchemyLab.AddItem(unlabeledVials);
        _alchemyLab.AddItem(alchemistsJournal);
        _alchemyLab.AddItem(alchemicalCauldron);

        _balconyGarden.AddItem(rareHerbs);
        _balconyGarden.AddItem(gardeningTools);
        _balconyGarden.AddItem(pottedPlants);
        _balconyGarden.AddItem(wateringCan);

        _frontEntrance.AddItem(ornateUmbrellaStand);
        _frontEntrance.AddItem(visitorsLog);
        _frontEntrance.AddItem(coatRack);

        _servantQuarters.AddItem(laundryBasket);
        _servantQuarters.AddItem(broom);
        _servantQuarters.AddItem(sewingKit);

        _ballRoom.AddItem(revealingPotion);
        _ballRoom.AddItem(antiqueMusicBox);
        _ballRoom.AddItem(chandelierCrystals);
        _ballRoom.AddItem(danceShoes);
        _ballRoom.AddItem(gildedMirror);

        _diningRoom.AddItem(silverwareSet);
        _diningRoom.AddItem(fineChina);
        _diningRoom.AddItem(crystalDecanter);
        _diningRoom.AddItem(linenNapkins);

        _kitchen.AddItem(chefsKnife);
        _kitchen.AddItem(spiceRack);
        _kitchen.AddItem(cuttingBoard);
        _kitchen.AddItem(rollingPin);

        _westWing.AddItem(crystalWand);
        _westWing.AddItem(portraitOfAnAncestor);
        _westWing.AddItem(decorativeVase);
        _westWing.AddItem(oldClock);
        _westWing.AddItem(framedLetters);
        _westWing.AddItem(sword);

        _hall.AddItem(candleHolder);
        _hall.AddItem(umbrella);
        _hall.AddItem(walkingCane);

        _eastWing.AddItem(secretChamberKey);
        _eastWing.AddItem(familyCrest);
        _eastWing.AddItem(lockedBox);
        _eastWing.AddItem(decorativePlates);
        _eastWing.AddItem(antiqueMirror);

        _guestRoom1.AddItem(travelDiary);
        _guestRoom1.AddItem(suitcase);
        _guestRoom1.AddItem(vanitySet);

        _guestRoom2.AddItem(writingDesk);
        _guestRoom2.AddItem(decorativePillow);

        _guestRoom3.AddItem(comfyChair);
        _guestRoom3.AddItem(blanket);

        _cellar.AddItem(hiddenCompartment);
        _cellar.AddItem(BarrelOfRum);
        _cellar.AddItem(oldTools);
        _cellar.AddItem(wineBottle);
        _cellar.AddItem(barrel);
        _cellar.AddItem(crate);

        _storageRoom.AddItem(rope);
        _storageRoom.AddItem(dustyBoxes);
        _storageRoom.AddItem(brokenFurniture);
        _storageRoom.AddItem(oldPaintings);

        _secretChamber.AddItem(courtyardKey);
        _secretChamber.AddItem(ancientRelic);
        _secretChamber.AddItem(codedManuscript);
        _secretChamber.AddItem(mysteriousAmulet);
        _secretChamber.AddItem(oldChest);

        // Assign Floors
        _secondFloor = new ArrayList<>(Arrays.asList(_library, _arcanum, _observatory, _alchemyLab, _balconyGarden));
        _groundFloor = new ArrayList<>(Arrays.asList(_courtyard,_frontEntrance, _servantQuarters, _ballRoom, _diningRoom, _kitchen, _westWing, _hall, _eastWing, _guestRoom1, _guestRoom2, _guestRoom3));
        _basement = new ArrayList<>(Arrays.asList(_cellar, _storageRoom, _secretChamber));

        // Set Starting Location
        _currentLocation = _frontEntrance;

        //throw new AssertionError();
    }
    
    public Map() {}

    public static String GetMapColor() {return mapColor;}
    public static String GetPlayerColor() {return playerColor;}

    public static void PrintMap(){
        int floor = Map.GetCurrentLocation().GetFloor();
        if (floor == 0){
            List<String> floorMap = UpdateBasementMap();
            System.out.println("_____________________________________________________________________");
            System.out.println("|                                                                   |");
            System.out.println("|                                                                   |");
            System.out.println("|                                                                   |");
            for(String line : floorMap){
                System.out.print("|              ");
                System.out.print(line);
                System.out.println("               |");
                //if(line != null && !line.trim().isEmpty()) { System.out.println(line); }
            }
            System.out.println("|                                                                   |");
            System.out.println("|                                                                   |");
            System.out.println("|                                                                   |");
            System.out.println("|___________________________________________________________________|");
        }
        else if (floor == 1){
            List<String> floorMap = UpdateGroundFloorMap();
            System.out.println("_____________________________________________________________________");
            for(String line : floorMap){
                System.out.print("|  ");
                System.out.print(line);
                System.out.println("  |");
                //if(line != null && !line.trim().isEmpty()) { System.out.println(line); }  
            }
            System.out.println("|___________________________________________________________________|");
        }
        else if (floor == 2){
            List<String> floorMap = UpdateSecondFloorMap();
            System.out.println("_____________________________________________________________________");
            System.out.println("|                                                                   |");
            System.out.println("|                                                                   |");
            for(String line : floorMap){
                System.out.print("|  ");
                System.out.print(line);
                System.out.println("  |");
                //if(line != null && !line.trim().isEmpty()) { System.out.println(line); }  
            }
            System.out.println("|                                                                   |");
            System.out.println("|                                                                   |");
            System.out.println("|                                                                   |");
            System.out.println("|___________________________________________________________________|");
        }
        else{
            System.out.println("couldn't find floor map");
        }
    }
    public static List<String> UpdateSecondFloorMap()
    {
        List<String> map = new ArrayList<>();
        String mapLine = "";

        // Line 1
        if(_library.GetVisited()){mapLine += "               _________________________________               ";}
        else{mapLine += "                                                               ";}
        map.add(mapLine);
        mapLine = "";

        // Line 2-3
        if(_library.GetVisited()){mapLine += "               |                               |               ";}
        else{mapLine += "                                                               ";}
        map.add(mapLine);
        map.add(mapLine);
        mapLine = "";

        // Line 4
        if(_library.GetVisited()){mapLine += "               |            Library            |               ";}
        else{mapLine += "                                                               ";}
        map.add(mapLine);
        mapLine = "";

        // Line 5
        if(_library.GetVisited()){mapLine += "               |         ";}
        else{mapLine += "                         ";}
        if(_library.GetIsCurrent()){mapLine += playerColor + "X" + mapColor;}
        else{mapLine += " ";}
        if(_library.GetVisited()){mapLine += "                     |               ";}
        else{mapLine += "                                     ";}
        map.add(mapLine);
        mapLine = "";

        // Line 6
        if(_arcanum.GetVisited()){mapLine += "_______________";}
        else{mapLine += "               ";}
        if(_library.GetVisited()){mapLine += "|";}
        else if(_arcanum.GetVisited()){mapLine += "_";}
        else{mapLine += " ";}
        if(_arcanum.GetVisited() || _library.GetVisited()){mapLine += "____";}
        else{mapLine += "    ";}
        if(_arcanum.GetVisited() || _library.GetVisited() || _observatory.GetVisited()){mapLine += "_";}
        else{mapLine += " ";}
        if(_observatory.GetVisited() || _library.GetVisited()){mapLine += "__________O__________";}
        else{mapLine += "                     ";}
        if(_alchemyLab.GetVisited() || _library.GetVisited() || _observatory.GetVisited()){mapLine += "_";}
        else{mapLine += " ";}
        if(_alchemyLab.GetVisited() || _library.GetVisited()){mapLine += "____";}
        else{mapLine += "    ";}
        if(_library.GetVisited()){mapLine += "|";}
        else if(_alchemyLab.GetVisited()){mapLine += "_";}
        else{mapLine += " ";}
        if(_alchemyLab.GetVisited()){mapLine += "_______________";}
        else{mapLine += "               ";}
        map.add(mapLine);
        mapLine = "";

        // Line 7-9
        if(_arcanum.GetVisited()){mapLine += "|                   ";}
        else{mapLine += "                    ";}
        if(_arcanum.GetVisited() || _observatory.GetVisited()){mapLine += "|                     ";}
        else{mapLine += "                      ";}
        if(_alchemyLab.GetVisited() || _observatory.GetVisited()){mapLine += "|                   ";}
        else{mapLine += "                    ";}
        if(_alchemyLab.GetVisited()){mapLine += "|";}
        else{mapLine += " ";}
        map.add(mapLine);
        map.add(mapLine);
        map.add(mapLine);
        mapLine = "";

        // Line 10
        if(_arcanum.GetVisited()){mapLine += "|      Arcanum      ";}
        else{mapLine += "                    ";}
        if(_arcanum.GetVisited() || _observatory.GetVisited()){mapLine += "O     ";}
        else{mapLine += "      ";}
        if(_observatory.GetVisited()){mapLine += "Observarory";}
        else{mapLine += "           ";}
        if(_alchemyLab.GetVisited() || _observatory.GetVisited()){mapLine += "     O    ";}
        else{mapLine += "          ";}
        if(_alchemyLab.GetVisited()){mapLine += "Alchemy Lab    |";}
        else{mapLine += "                ";}
        map.add(mapLine);
        mapLine = "";

        // Line 11-12
        if(_arcanum.GetVisited()){mapLine += "|                   ";}
        else{mapLine += "                    ";}
        if(_arcanum.GetVisited() || _observatory.GetVisited()){mapLine += "|                     ";}
        else{mapLine += "                      ";}
        if(_alchemyLab.GetVisited() || _observatory.GetVisited()){mapLine += "|                   ";}
        else{mapLine += "                    ";}
        if(_alchemyLab.GetVisited()){mapLine += "|";}
        else{mapLine += " ";}
        map.add(mapLine);
        map.add(mapLine);
        mapLine = "";

        // Line 13
        if(_arcanum.GetVisited()){mapLine += "|=|       ";}
        else{mapLine += "          ";}
        if(_arcanum.GetIsCurrent()){mapLine += playerColor + "X         " + mapColor;}
        else{mapLine += "          ";}
        if(_arcanum.GetVisited() || _observatory.GetVisited()){mapLine += "|     ";}
        else{mapLine += "      ";}
        if(_observatory.GetIsCurrent()){mapLine += playerColor + "X               " + mapColor;}
        else{mapLine += "                ";}
        if(_alchemyLab.GetVisited() || _observatory.GetVisited()){mapLine += "|         ";}
        else{mapLine += "          ";}
        if(_alchemyLab.GetIsCurrent()){mapLine += playerColor + "X       " + mapColor;}
        else{mapLine += "        ";}
        if(_alchemyLab.GetVisited()){mapLine += "|=|";}
        else{mapLine += "   ";}
        map.add(mapLine);
        mapLine = "";

        // Line 14
        if(_arcanum.GetVisited()){mapLine += "|=|_______";}
        else{mapLine += "          ";}
        if(_arcanum.GetVisited() || _balconyGarden.GetVisited()){mapLine += "__________";}
        else{mapLine += "          ";}
        if(_arcanum.GetVisited() || _observatory.GetVisited()){mapLine += "|";}
        else if(_balconyGarden.GetVisited()){mapLine += "_";}
        else{mapLine += " ";}
        if(_balconyGarden.GetVisited() || _observatory.GetVisited()){mapLine += "__________O__________";}
        else{mapLine += "                     ";}
        if(_alchemyLab.GetVisited() || _observatory.GetVisited()){mapLine += "|";}
        else if(_balconyGarden.GetVisited()){mapLine += "_";}
        else{mapLine += " ";}
        if(_alchemyLab.GetVisited() || _balconyGarden.GetVisited()){mapLine += "__________";}
        else{mapLine += "          ";}
        if(_alchemyLab.GetVisited()){mapLine += "_______|=|";}
        else{mapLine += "          ";}
        map.add(mapLine);
        mapLine = "";

        // Line 15-16
        if(_balconyGarden.GetVisited()){mapLine += "          |                                         |          ";}
        else{mapLine += "                                                               ";}
        map.add(mapLine);
        map.add(mapLine);
        mapLine = "";

        // Line 17
        if(_balconyGarden.GetVisited()){mapLine += "          |       ";}
        else{mapLine += "                  ";}
        if(_balconyGarden.GetIsCurrent()){mapLine += playerColor + "X" + mapColor;}
        else{mapLine += " ";}
        if(_balconyGarden.GetVisited()){mapLine += "      Balcony Garden             |          ";}
        else{mapLine += "                                            ";}
        map.add(mapLine);
        mapLine = "";

        // Line 18
        if(_balconyGarden.GetVisited()){mapLine += "          |_________________________________________|          ";}
        else{mapLine += "                                                               ";}
        map.add(mapLine);
        mapLine = "";

        return map;
    }
    public static List<String> UpdateGroundFloorMap()
    {
        List<String> map = new ArrayList<>();
        String mapLine = "";

        // Line 1
        if(_frontEntrance.GetVisited()){mapLine += "    __________________                   ";}
        else{mapLine += "                                         ";}
        if(_servantQuarters.GetVisited()){mapLine += "__________________    ";}
        else{mapLine += "                      ";}
        map.add(mapLine);
        mapLine = "";

        // Line 2
        if(_frontEntrance.GetVisited()){mapLine += "    | Front Entrance |                   ";}
        else{mapLine += "                                         ";}
        if(_servantQuarters.GetVisited()){mapLine += "|Servant Quarters|    ";}
        else{mapLine += "                      ";}
        map.add(mapLine);
        mapLine = "";

        // Line 3
        if(_frontEntrance.GetVisited()){mapLine += "    |                |                   ";}
        else{mapLine += "                                         ";}
        if(_servantQuarters.GetVisited()){mapLine += "|                |    ";}
        else{mapLine += "                      ";}
        map.add(mapLine);
        mapLine = "";

        // Line 4
        if(_frontEntrance.GetVisited()){mapLine += "    |       ";}
        else{mapLine += "            ";}
        if(_frontEntrance.GetIsCurrent()){mapLine += playerColor + "X" + mapColor;}
        else{mapLine += " ";}
        if(_frontEntrance.GetVisited()){mapLine += "        O                   ";}
        else{mapLine += "                            ";}
        if(_servantQuarters.GetVisited()){mapLine += "O        ";}
        else{mapLine += "         ";}
        if(_servantQuarters.GetIsCurrent()){mapLine += playerColor + "X" + mapColor;}
        else{mapLine += " ";}
        if(_servantQuarters.GetVisited()){mapLine += "       |    ";}
        else{mapLine += "            ";}
        map.add(mapLine);
        mapLine = "";

        // Line 5
        if(_frontEntrance.GetVisited()){mapLine += "    |                |                   ";}
        else{mapLine += "                                         ";}
        if(_servantQuarters.GetVisited()){mapLine += "|              |=|    ";}
        else{mapLine += "                      ";}
        map.add(mapLine);
        mapLine = "";

        // Line 6
        if(_ballRoom.GetVisited()){mapLine += "____";}
        else{mapLine += "    ";}
        if(_frontEntrance.GetVisited()){mapLine += "|_______O________|";}
        else if(_ballRoom.GetVisited()){mapLine += "________O_________";}
        else{mapLine += "                  ";}
        if(_ballRoom.GetVisited()){mapLine += "___";}
        else{mapLine += "   ";}
        if(_ballRoom.GetVisited() || _diningRoom.GetVisited()){mapLine += "_";}
        else{mapLine += " ";}
        if(_diningRoom.GetVisited()){mapLine += "_____O_____";}
        else{mapLine += "           ";}
        if(_kitchen.GetVisited() || _diningRoom.GetVisited()){mapLine += "_";}
        else{mapLine += " ";}
        if(_kitchen.GetVisited()){mapLine += "___";}
        else{mapLine += "   ";}
        if(_servantQuarters.GetVisited()){mapLine += "|________O_____|=|";}
        else if(_kitchen.GetVisited()){mapLine += "________O_________";}
        else{mapLine += "                  ";}
        if(_kitchen.GetVisited()){mapLine += "____";}
        else{mapLine += "    ";}
        map.add(mapLine);
        mapLine = "";

        // Line 7-8
        if(_ballRoom.GetVisited()){mapLine += "|                        ";}
        else{mapLine += "                         ";}
        if(_ballRoom.GetVisited() || _diningRoom.GetVisited()){mapLine += "|         ";}
        else{mapLine += "          ";}
        if(_diningRoom.GetVisited()){mapLine += "|=";}
        else{mapLine += "  ";}
        if(_kitchen.GetVisited() || _diningRoom.GetVisited()){mapLine += "|                        ";}
        else{mapLine += "                         ";}
        if(_kitchen.GetVisited()){mapLine += "|";}
        else{mapLine += " ";}
        map.add(mapLine);
        map.add(mapLine);
        mapLine = "";

        // Line 9
        if(_ballRoom.GetVisited()){mapLine += "|       Ball Room        ";}
        else{mapLine += "                         ";}
        if(_ballRoom.GetVisited() || _diningRoom.GetVisited()){mapLine += "O           ";}
        else{mapLine += "            ";}
        if(_kitchen.GetVisited() || _diningRoom.GetVisited()){mapLine += "O         ";}
        else{mapLine += "          ";}
        if(_kitchen.GetVisited()){mapLine += "Kitchen        |";}
        else{mapLine += "                ";}
        map.add(mapLine);
        mapLine = "";

        // Line 10
        if(_ballRoom.GetVisited()){mapLine += "|                   ";}
        else{mapLine += "                    ";}
        if(_ballRoom.GetIsCurrent()){mapLine += playerColor + "X" + mapColor;}
        else{mapLine += " ";}
        if(_ballRoom.GetVisited() || _diningRoom.GetVisited()){mapLine += "    |  ";}
        else{mapLine += "       ";}
        if(_diningRoom.GetVisited()){mapLine += "Dining";}
        else{mapLine += "      ";}
        if(_kitchen.GetVisited() || _diningRoom.GetVisited()){mapLine += "   |     ";}
        else{mapLine += "         ";}
        if(_kitchen.GetIsCurrent()){mapLine += playerColor + "X" + mapColor;}
        else{mapLine += " ";}
        if(_kitchen.GetVisited()){mapLine += "                  |";}
        else{mapLine += "                   ";}
        map.add(mapLine);
        mapLine = "";

        // Line 11
        if(_ballRoom.GetVisited()){mapLine += "|";}
        else if(_westWing.GetVisited()){mapLine += "_";}
        else{mapLine += " ";}
        if(_ballRoom.GetVisited() || _westWing.GetVisited()){mapLine += "_________O_________";}
        else{mapLine += "                   ";}
        if(_ballRoom.GetVisited() || _westWing.GetVisited() || _hall.GetVisited()){mapLine += "_";}
        else{mapLine += " ";}
        if(_ballRoom.GetVisited() || _hall.GetVisited()){mapLine += "_O__";}
        else{mapLine += "    ";}
        if(_diningRoom.GetVisited() || _ballRoom.GetVisited()){mapLine += "|";}
        else if(_hall.GetVisited()){mapLine += "_";}
        else{mapLine += " ";}
        if(_diningRoom.GetVisited()){mapLine += "     Room  ";}
        else{mapLine += "           ";}
        if(_diningRoom.GetVisited() || _kitchen.GetVisited()){mapLine += "|";}
        else if(_hall.GetVisited()){mapLine += "_";}
        else{mapLine += " ";}
        if(_kitchen.GetVisited() || _hall.GetVisited()){mapLine += "_O__";}
        else{mapLine += "    ";}
        if(_kitchen.GetVisited() || _eastWing.GetVisited() || _hall.GetVisited()){mapLine += "_";}
        else{mapLine += " ";}
        if(_kitchen.GetVisited() || _eastWing.GetVisited()){mapLine += "_________O_________";}
        else{mapLine += "                   ";}
        if(_kitchen.GetVisited()){mapLine += "|";}
        else if(_eastWing.GetVisited()){mapLine += "_";}
        else{mapLine += " ";}
        map.add(mapLine);
        mapLine = "";

        // Line 12-14
        if(_westWing.GetVisited()){mapLine += "|                   ";}
        else{mapLine += "                    ";}
        if(_westWing.GetVisited() || _hall.GetVisited()){mapLine += "|    ";}
        else{mapLine += "     ";}
        if(_diningRoom.GetVisited() || _hall.GetVisited()){mapLine += "|           |    ";}
        else{mapLine += "                 ";}
        if(_eastWing.GetVisited() || _hall.GetVisited()){mapLine += "|                   ";}
        else{mapLine += "                    ";}
        if(_eastWing.GetVisited()){mapLine += "|";}
        else{mapLine += " ";}
        map.add(mapLine);
        map.add(mapLine);
        map.add(mapLine);
        mapLine = "";

        // Line 15
        if(_westWing.GetVisited()){mapLine += "|     West Wing     ";}
        else{mapLine += "                    ";}
        if(_westWing.GetVisited() || _hall.GetVisited()){mapLine += "O    ";}
        else{mapLine += "     ";}
        if(_diningRoom.GetVisited() || _hall.GetVisited()){mapLine += "|     ";}
        else{mapLine += "      ";}
        if(_diningRoom.GetIsCurrent()){mapLine += playerColor + "X" + mapColor;}
        else{mapLine += " ";}
        if(_diningRoom.GetVisited() || _hall.GetVisited()){mapLine += "     |";}
        else{mapLine += "      ";}
        if(_eastWing.GetVisited() || _hall.GetVisited()){mapLine += "    O     ";}
        else{mapLine += "          ";}
        if(_eastWing.GetVisited()){mapLine += "East Wing     |";}
        else{mapLine += "               ";}
        map.add(mapLine);
        mapLine = "";

        // Line 16
        if(_westWing.GetVisited()){mapLine += "|                   ";}
        else{mapLine += "                    ";}
        if(_westWing.GetVisited() || _hall.GetVisited()){mapLine += "|    ";}
        else{mapLine += "     ";}
        if(_diningRoom.GetVisited() || _hall.GetVisited()){mapLine += "|           |    ";}
        else{mapLine += "                 ";}
        if(_eastWing.GetVisited() || _hall.GetVisited()){mapLine += "|                   ";}
        else{mapLine += "                    ";}
        if(_eastWing.GetVisited()){mapLine += "|";}
        else{mapLine += " ";}
        map.add(mapLine);
        mapLine = "";

        // Line 17
        if(_westWing.GetVisited()){mapLine += "|         ";}
        else{mapLine += "          ";}
        if(_westWing.GetIsCurrent()){mapLine += playerColor + "X         " + mapColor;}
        else{mapLine += "          ";}
        if(_westWing.GetVisited() || _hall.GetVisited()){mapLine += "|    ";}
        else{mapLine += "     ";}
        if(_diningRoom.GetVisited() || _hall.GetVisited()){mapLine += "|_____O_____|    ";}
        else{mapLine += "                 ";}
        if(_eastWing.GetVisited() || _hall.GetVisited()){mapLine += "|         ";}
        else{mapLine += "          ";}
        if(_eastWing.GetIsCurrent()){mapLine += playerColor + "X" + mapColor;}
        else{mapLine += " ";}
        if(_eastWing.GetVisited()){mapLine += "         |";}
        else{mapLine += "          ";}
        map.add(mapLine);
        mapLine = "";

        // Line 18
        if(_westWing.GetVisited()){mapLine += "|=|                 ";}
        else{mapLine += "                    ";}
        if(_westWing.GetVisited() || _hall.GetVisited()){mapLine += "|    ";}
        else{mapLine += "     ";}
        if(_hall.GetIsCurrent()){mapLine += playerColor + "X    " + mapColor;}
        else{mapLine += "     ";}
        if(_hall.GetVisited()){mapLine += "Hall        ";}
        else{mapLine += "            ";}
        if(_eastWing.GetVisited() || _hall.GetVisited()){mapLine += "|                 ";}
        else{mapLine += "                  ";}
        if(_eastWing.GetVisited()){mapLine += "|=|";}
        else{mapLine += "   ";}
        map.add(mapLine);
        mapLine = "";

        // Line 19
        if(_westWing.GetVisited()){mapLine += "|=|_______";}
        else{mapLine += "          ";}
        if(_westWing.GetVisited() || _guestRoom1.GetVisited()){mapLine += "__________";}
        else{mapLine += "          ";}
        if(_westWing.GetVisited() || _hall.GetVisited()){mapLine += "|";}
        else if(_guestRoom1.GetVisited()){mapLine += "_";}
        else{mapLine += " ";}
        if(_guestRoom1.GetVisited() || _hall.GetVisited()){mapLine += "_O_";}
        else{mapLine += "   ";}
        if(_hall.GetVisited() || _guestRoom1.GetVisited() || _guestRoom2.GetVisited()){mapLine += "_";}
        else{mapLine += " ";}
        if(_guestRoom2.GetVisited() || _hall.GetVisited()){mapLine += "______O______";}
        else{mapLine += "             ";}
        if(_hall.GetVisited() || _guestRoom3.GetVisited() || _guestRoom2.GetVisited()){mapLine += "_";}
        else{mapLine += " ";}
        if(_guestRoom3.GetVisited() || _hall.GetVisited()){mapLine += "_O_";}
        else{mapLine += "   ";}
        if(_eastWing.GetVisited() || _hall.GetVisited()){mapLine += "|";}
        else if(_guestRoom3.GetVisited()){mapLine += "_";}
        else{mapLine += " ";}
        if(_eastWing.GetVisited() || _guestRoom3.GetVisited()){mapLine += "__________";}
        else{mapLine += "          ";}
        if(_eastWing.GetVisited()){mapLine += "_______|=|";}
        else{mapLine += "          ";}
        map.add(mapLine);
        mapLine = "";
        
        // Line 20
        if(_guestRoom1.GetVisited()){mapLine += "          |      ";}
        else{mapLine += "                 ";}
        if(_guestRoom1.GetIsCurrent()){mapLine += playerColor + "X" + mapColor;}
        else{mapLine += " ";}
        if(_guestRoom1.GetVisited() || _guestRoom2.GetVisited()){mapLine += "      |      ";}
        else{mapLine += "             ";}
        if(_guestRoom2.GetIsCurrent()){mapLine += playerColor + "X" + mapColor;}
        else{mapLine += " ";}
        if(_guestRoom2.GetVisited() || _guestRoom3.GetVisited()){mapLine += "      |      ";}
        else{mapLine += "             ";}
        if(_guestRoom3.GetIsCurrent()){mapLine += playerColor + "X" + mapColor;}
        else{mapLine += " ";}
        if(_guestRoom3.GetVisited()){mapLine += "      |          ";}
        else{mapLine += "                 ";}
        map.add(mapLine);
        mapLine = "";

        // Line 21
        if(_guestRoom1.GetVisited()){mapLine += "          |    Guest    ";}
        else{mapLine += "                        ";}
        if(_guestRoom1.GetVisited() || _guestRoom2.GetVisited()){mapLine += "|    ";}
        else{mapLine += "     ";}
        if(_guestRoom2.GetVisited()){mapLine += "Guest    ";}
        else{mapLine += "         ";}
        if(_guestRoom2.GetVisited() || _guestRoom3.GetVisited()){mapLine += "|    ";}
        else{mapLine += "     ";}
        if(_guestRoom3.GetVisited()){mapLine += "Guest    |          ";}
        else{mapLine += "                    ";}
        map.add(mapLine);
        mapLine = "";

        // Line 22
        if(_guestRoom1.GetVisited()){mapLine += "          |    Room 1   ";}
        else{mapLine += "                        ";}
        if(_guestRoom1.GetVisited() || _guestRoom2.GetVisited()){mapLine += "|    ";}
        else{mapLine += "     ";}
        if(_guestRoom2.GetVisited()){mapLine += "Room 2   ";}
        else{mapLine += "         ";}
        if(_guestRoom2.GetVisited() || _guestRoom3.GetVisited()){mapLine += "|    ";}
        else{mapLine += "     ";}
        if(_guestRoom3.GetVisited()){mapLine += "Room 3   |          ";}
        else{mapLine += "                    ";}
        map.add(mapLine);
        mapLine = "";

        // Line 23
        if(_guestRoom1.GetVisited()){mapLine += "          |_____________";}
        else{mapLine += "                        ";}
        if(_guestRoom1.GetVisited() || _guestRoom2.GetVisited()){mapLine += "|";}
        else{mapLine += " ";}
        if(_guestRoom2.GetVisited()){mapLine += "_____________";}
        else{mapLine += "             ";}
        if(_guestRoom2.GetVisited() || _guestRoom3.GetVisited()){mapLine += "|";}
        else{mapLine += " ";}
        if(_guestRoom3.GetVisited()){mapLine += "_____________|          ";}
        else{mapLine += "                        ";}
        map.add(mapLine);
        mapLine = "";

        // Complete map
        return map;
    }
    public static List<String> UpdateBasementMap()
    {
        List<String> map = new ArrayList<>();
        String mapLine = "";

        // Line 1
        if(_cellar.GetVisited()){mapLine += "                __________________    ";}
        else{mapLine += "                                      ";}
        map.add(mapLine);
        mapLine = "";

        // Line 2
        if(_cellar.GetVisited()){mapLine += "                |     Cellar     |    ";}
        else{mapLine += "                                      ";}
        map.add(mapLine);
        mapLine = "";

        // Line 3-4
        if(_cellar.GetVisited()){mapLine += "                |                |    ";}
        else{mapLine += "                                      ";}
        map.add(mapLine);
        map.add(mapLine);
        mapLine = "";

        // Line 5
        if(_cellar.GetVisited()){mapLine += "                |    ";}
        else{mapLine += "                     ";}
        if(_cellar.GetIsCurrent()){mapLine += playerColor + "X" + mapColor;}
        else{mapLine += " ";}
        if(_cellar.GetVisited()){mapLine += "         |=|    ";}
        else{mapLine += "                ";}
        map.add(mapLine);
        mapLine = "";

        // Line 6
        if(_secretChamber.GetVisited()){mapLine += "____________";}
        else{mapLine += "            ";}
        if(_secretChamber.GetVisited() || _storageRoom.GetVisited()){mapLine += "_";}
        else{mapLine += " ";}
        if(_storageRoom.GetVisited()){mapLine += "___";}
        else{mapLine += "   ";}
        if(_cellar.GetVisited()){mapLine += "|";}
        else if(_storageRoom.GetVisited()){mapLine += "_";}
        else{mapLine += " ";}
        if(_storageRoom.GetVisited() || _cellar.GetVisited()){mapLine += "________O_____";}
        else{mapLine += "              ";}
        if(_cellar.GetVisited()){mapLine += "|=|";}
        else if(_storageRoom.GetVisited()){mapLine += "___";}
        else{mapLine += "   ";}
        if(_storageRoom.GetVisited()){mapLine += "____";}
        else{mapLine += "    ";}
        map.add(mapLine);
        mapLine = "";

        // Line 7-8
        if(_secretChamber.GetVisited()){mapLine += "|         |=";}
        else{mapLine += "            ";}
        if(_secretChamber.GetVisited() || _storageRoom.GetVisited()){mapLine += "|";}
        else{mapLine += " ";}
        if(_storageRoom.GetVisited()){mapLine += "                        |";}
        else{mapLine += "                         ";}
        map.add(mapLine);
        map.add(mapLine);
        mapLine = "";

        // Line 9
        if(_secretChamber.GetVisited()){mapLine += "|     ";}
        else{mapLine += "      ";}
        if(_secretChamber.GetIsCurrent()){mapLine += playerColor + "X     " + mapColor;}
        else{mapLine += "      ";}
        if(_secretChamber.GetVisited() || _storageRoom.GetVisited()){mapLine += "O";}
        else{mapLine += " ";}
        if(_storageRoom.GetVisited()){mapLine += "      Storage Room      |";}
        else{mapLine += "                         ";}
        map.add(mapLine);
        mapLine = "";

        // Line 10
        if(_secretChamber.GetVisited()){mapLine += "| Secret    ";}
        else{mapLine += "            ";}
        if(_secretChamber.GetVisited() || _storageRoom.GetVisited()){mapLine += "|            ";}
        else{mapLine += "             ";}
        if(_storageRoom.GetIsCurrent()){mapLine += playerColor + "X" + mapColor;}
        else{mapLine += " ";}
        if(_storageRoom.GetVisited()){mapLine += "           |";}
        else{mapLine += "            ";}
        map.add(mapLine);
        mapLine = "";

        // Line 11
        if(_secretChamber.GetVisited()){mapLine += "|   Chamber ";}
        else{mapLine += "            ";}
        if(_secretChamber.GetVisited() || _storageRoom.GetVisited()){mapLine += "|";}
        else{mapLine += " ";}
        if(_storageRoom.GetVisited()){mapLine += "________________________|";}
        else{mapLine += "                         ";}
        map.add(mapLine);
        mapLine = "";

        // Line 12-16
        if(_secretChamber.GetVisited()){mapLine += "|           |                         ";}
        else{mapLine += "                                      ";}
        map.add(mapLine);
        map.add(mapLine);
        map.add(mapLine);
        map.add(mapLine);
        map.add(mapLine);
        mapLine = "";

        // Line 17
        if(_secretChamber.GetVisited()){mapLine += "|___________|                         ";}
        else{mapLine += "                                      ";}
        map.add(mapLine);
        mapLine = "";

        return map;
    }

    public static Location GetCurrentLocation() {return _currentLocation;}
    public static void SetCurrentLocation(Location location) {_currentLocation = location;}
}



/*
"_____________________________________________________________________"01
"|                                                                   |"02
"|                                                                   |"03
"|                 _________________________________                 |"04 01
"|                 |                               |                 |"05 02
"|                 |                               |                 |"06 03
"|                 |            Library            |                 |"07 04
"|                 |         X                     |                 |"08 05
"|  _______________|_______________O_______________|_______________  |"09 06
"|  |                   |                     |                   |  |"10 07
"|  |                   |                     |                   |  |"11 08
"|  |                   |                     |                   |  |"12 09
"|  |      Arcanum      O     Observarory     O    Alchemy Lab    |  |"13 10
"|  |                   |                     |                   |  |"14 11
"|  |                   |                     |                   |  |"15 12
"|  |=|       X         |     X               |         X       |=|  |"16 13
"|  |=|_________________|__________O__________|_________________|=|  |"17 14
"|            |                                         |            |"18 15
"|            |                                         |            |"19 16
"|            |       X      Balcony Garden             |            |"20 17
"|            |_________________________________________|            |"21 18
"|                                                                   |"22
"|                                                                   |"23
"|                                                                   |"24
"|___________________________________________________________________|"25
*/
/*
"_____________________________________________________________________"01
"|      __________________                   __________________      |"02
"|      | Front Entrance |                   |Servant Quarters|      |"03
"|      |                |                   |                |      |"04
"|      |       X        O                   O        X       |      |"05
"|      |                |                   |              |=|      |"06
"|  ____|_______O________|_________O_________|________O_____|=|____  |"07
"|  |                        |         |=|                        |  |"08
"|  |                        |         |=|                        |  |"09
"|  |       Ball Room        O           O         Kitchen        |  |"10
"|  |                   X    |  Dining   |     X                  |  |"11
"|  |_________O___________O__|     Room  |__O___________O_________|  |"12
"|  |                   |    |           |    |                   |  |"13
"|  |                   |    |           |    |                   |  |"14
"|  |                   |    |           |    |                   |  |"15
"|  |     West Wing     O    |     X     |    O     East Wing     |  |"16
"|  |                   |    |           |    |                   |  |"17
"|  |         X         |    |_____O_____|    |         X         |  |"18
"|  |=|                 |    X    Hall        |                 |=|  |"19
"|  |=|_________________|_O________O________O_|_________________|=|  |"20
"|            |      X      |      X      |      X      |            |"21
"|            |    Guest    |    Guest    |    Guest    |            |"22
"|            |    Room 1   |    Room 2   |    Room 3   |            |"23
"|            |_____________|_____________|_____________|            |"24
"|___________________________________________________________________|"25
*/
/*
"_____________________________________________________________________"01
"|                                                                   |"02
"|                                                                   |"03
"|                                                                   |"04
"|                              __________________                   |"05
"|                              |     Cellar     |                   |"06
"|                              |                |                   |"07
"|                              |                |                   |"08
"|                              |    X         |=|                   |"09
"|              ________________|________O_____|=|____               |"10
"|              |         |=|                        |               |"11
"|              |         |=|                        |               |"12
"|              |     X     O      Storage Room      |               |"13
"|              | Secret    |            X           |               |"14
"|              |   Chamber |________________________|               |"15
"|              |           |                                        |"16
"|              |           |                                        |"17
"|              |           |                                        |"18
"|              |           |                                        |"19
"|              |           |                                        |"20
"|              |___________|                                        |"21
"|                                                                   |"22
"|                                                                   |"23
"|                                                                   |"24
"|___________________________________________________________________|"25
*/
