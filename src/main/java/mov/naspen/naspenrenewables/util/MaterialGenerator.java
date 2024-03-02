package mov.naspen.naspenrenewables.util;

import org.bukkit.Material;

public class MaterialGenerator {

    private static Material[] deepStoneMap;
    private static int[] deepStoneWeights;
    private static Material[] deepCobbleMap;
    private static int[] deepCobbleWeights;
    private static Material[] surfaceStoneMap;
    private static int[] surfaceStoneWeights;

    public static void init(){
        //set deep cobble map
        deepCobbleMap = new Material[1];
        deepCobbleWeights = new int[1];
        deepCobbleMap[0] = Material.COBBLED_DEEPSLATE;
        deepCobbleWeights[0] = 75;
        //set deep stone map
        deepStoneMap = new Material[1];
        deepStoneWeights = new int[1];
        deepStoneMap[0] = Material.DEEPSLATE;
        deepStoneWeights[0] = 90;
        //set the surface stone map
        surfaceStoneMap = new Material[4];
        surfaceStoneWeights = new int[4];
        surfaceStoneMap[0] = Material.STONE;
        surfaceStoneWeights[0] = 70;
        surfaceStoneMap[1] = Material.ANDESITE;
        surfaceStoneWeights[1] = 10;
        surfaceStoneMap[2] = Material.DIORITE;
        surfaceStoneWeights[2] = 10;
        surfaceStoneMap[3] = Material.GRANITE;
        surfaceStoneWeights[3] = 10;
    }
    public static Material getRandomDeepType(){
        return getRandomMaterial(deepStoneMap,deepStoneWeights);
    }
    public static Material getRandomCobbleDeepType(){
        return getRandomMaterial(deepCobbleMap,deepCobbleWeights);
    }
    public static Material getRandomStoneType(){
        return getRandomMaterial(surfaceStoneMap, surfaceStoneWeights);
    }
    public static Material getRandomMaterial(Material[] map, int[] weights){
    int totalWeight = 0;
        for (int weight : weights) {
            totalWeight += weight;
        }
        int random = (int) (Math.random() * totalWeight);
        for (int i = 0; i < map.length; i++) {
            random -= weights[i];
            if (random < 0) {
                return map[i];
            }
        }
        return null;
    }
}
