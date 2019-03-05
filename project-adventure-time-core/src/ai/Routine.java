package ai;

import com.badlogic.gdx.scenes.scene2d.Stage;
import definitions.actors.BaseNPC;

public abstract class Routine {
 
    public enum RoutineState {
    	
        Success,
        Failure,
        Running
    }
 
    protected RoutineState state;
 
    protected Routine() { }
 
    public void start() {
    	
        this.state = RoutineState.Running;
    }
 
    public abstract void reset();
 
    public abstract void act(BaseNPC npc, Stage stage);
 
    protected void succeed() {
    	
        this.state = RoutineState.Success;
    }
 
    protected void fail() {
    	
        this.state = RoutineState.Failure;
    }
 
    public boolean isSuccess() {
    	
        return state.equals(RoutineState.Success);
    }
 
    public boolean isFailure() {
    	
        return state.equals(RoutineState.Failure);
    }
 
    public boolean isRunning() {
    	
        return state.equals(RoutineState.Running);
    }
 
    public RoutineState getState() {
    	
        return state;
    }
}