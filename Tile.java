import java.util.Arrays;
public class Tile{
  public Integer[] cords;
  public String tileType;
  public int[] midpoint;
  public Tile(Integer[] tilecords,String type){
    cords = tilecords;
    tileType=type;
    midpoint = new int[2];
    midpoint[0] = cords[0]+16;
    midpoint[1] = cords[1]+24;
  }



  public static Tile genbotRTile(Tile ben,String type){
    Integer[] newcords = new Integer[2];
    newcords[0] = ben.cords[0]+16;
    newcords[1] = ben.cords[1]+21;
    //System.out.println("test: "+Arrays.toString(newcords));
    Tile benbruh =new Tile(newcords,type);
    
    
    return benbruh;
    
  }
  public static Tile genRTile(Tile ben,String type){
    Integer[] newcords = new Integer[2];
    newcords[0] = ben.cords[0]+32;
    newcords[1] = ben.cords[1];
    //System.out.println("test: "+Arrays.toString(newcords));
    Tile benbruh =new Tile(newcords,type);


    return benbruh;

  }

  public static Tile genLTile(Tile ben,String type){
    Integer[] newcords = new Integer[2];
    newcords[0] = ben.cords[0]-32;
    newcords[1] = ben.cords[1];
    //System.out.println("test: "+Arrays.toString(newcords));
    Tile benbruh =new Tile(newcords,type);


    return benbruh;

  }

  public static Tile genbotLTile(Tile ben,String type){
    Integer[] newcords = new Integer[2];
    newcords[0] = ben.cords[0]-16;
    newcords[1] = ben.cords[1]+21;
    //System.out.println("test: "+Arrays.toString(newcords));
    Tile benbruh =new Tile(newcords,type);


    return benbruh;

  }
  public static Tile genbtopLTile(Tile ben,String type){
    Integer[] newcords = new Integer[2];
    newcords[0] = ben.cords[0]-16;
    newcords[1] = ben.cords[1]-21;
    //System.out.println("test: "+Arrays.toString(newcords));
    Tile benbruh =new Tile(newcords,type);


    return benbruh;

  }
  public static Tile gentopRTile(Tile ben,String type){
    Integer[] newcords = new Integer[2];
    newcords[0] = ben.cords[0]+16;
    newcords[1] = ben.cords[1]-21;
    //System.out.println("test: "+Arrays.toString(newcords));
    Tile benbruh =new Tile(newcords,type);


    return benbruh;

  }

}