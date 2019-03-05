package ai;

import java.util.ArrayList;
import java.util.List;

import definitions.actors.BaseNPC;

public class NPCList {
	
	final int width;
    final int height;

	public List<BaseNPC> npcList = new ArrayList<BaseNPC>();
	
	public NPCList(int width, int height) {
		
		this.width = width;
		this.height = height;
	}
	
	public int getWidth() {
		
        return width;
    }
 
    public int getHeight() {
    	
        return height;
    }
    
    public void addNPC(BaseNPC npc) {
    	
    	if(isTileWalkable(npc.getX(), npc.getY())) {
    		
    		npcList.add(npc);
    	}
    }
    
    public boolean isTileWalkable(float posX, float posY) {
    	
    	for (BaseNPC npc : npcList) {
    		
    		if(npc.getX() == posX && npc.getY() == posY) {
    			
    			return false;
    		}
    	}
		return false;
    }
    
    public List<BaseNPC> getNPCList(){
    	
    	return npcList;
    }
}
