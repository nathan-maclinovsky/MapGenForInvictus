import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

public class Map {
 
  static List<Tile> tilelist;
  private static HashMap<String, Integer> tilelistcords = new HashMap<>();
  
  
  
  public static void genMap() {
  JSONObject map = new JSONObject();
  List<JSONObject> list = new ArrayList<>();
  Integer[] mytilecords = new Integer[2];
  mytilecords[0] = 750;
  mytilecords[1] = 750;

  Tile center = new Tile(mytilecords,"grass");
  tilelist = genHex(center,true);
     for(int i = 0; i < 722; i++){
       tilelist.addAll(genHex(tilelist.get(i),false));
     }
  System.out.println(tilelist.size());

    addMountains(tilelist,20);
    tilelist.sort((a, b) -> a.cords[1].compareTo(b.cords[1]));
    
    for(int i = 0; i < tilelist.size(); i++){
       List<Integer> curentcords= Arrays.asList(tilelist.get(i).cords);
       JSONObject tile = new JSONObject();
       tile.put("coords",curentcords);
       tile.put("type",tilelist.get(i).tileType);
       list.add(tile);
     }
     map.put("tileList",list);





      try {
         FileWriter file = new FileWriter("db.js");
        file.write("var tiles = ");
          file.write(map.toJSONString());
        file.write("\n window.tiles = tiles");
         file.close();
      } catch (IOException e) {
        
         e.printStackTrace();
      }
      System.out.println("JSON file created: "+map);



   }

  
    public static List<Tile> genHex(Tile ocean,boolean needscenter){
      List<Tile> list = new ArrayList<>();
      Tile ben5 = Tile.genbtopLTile(ocean,"grass");
      if(addtile(ben5)== true){
      list.add(ben5);
      }
      Tile ben6 = Tile.gentopRTile(ocean,"grass");
      if(addtile(ben6)== true){
      list.add(ben6);
      }

      Tile ben4 = Tile.genLTile(ocean,"grass");
      if(addtile(ben4)== true){
      list.add(ben4);
      }
      if(needscenter == true){
      list.add(ocean);
      }
      Tile ben3 = Tile.genRTile(ocean,"grass");
      if(addtile(ben3)== true){
      list.add(ben3);
      }
      Tile ben2 = Tile.genbotLTile(ocean,"grass");
      if(addtile(ben2)== true){
      list.add(ben2);
      }
      Tile ben = Tile.genbotRTile(ocean,"grass");
      if(addtile(ben)== true){
      list.add(ben);
      }



      return list;


  }
  public static boolean addtile(Tile tile){
    String cords = Arrays.toString(tile.cords);
    if(tilelistcords.containsKey(cords) == true){
      return false;
    }
    else{
      tilelistcords.put(cords,1);
      return true;
    }


  }
  public static void addMountains(List<Tile> tilelist,int upperlim){
    int numMounts = (int)(Math.random()*upperlim);
    for(int i = 0; i < numMounts; i++){
      int index = (int)(Math.random()*tilelist.size());
      tilelist.get(index).setType("Mountain");
    }
  }



}