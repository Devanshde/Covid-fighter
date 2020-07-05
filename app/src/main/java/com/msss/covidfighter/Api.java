package com.msss.covidfighter;

public class Api
{
    private State[] state;

    public State[] getState ()
    {
        return state;
    }

    public void setState (State[] state)
    {
        this.state = state;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [state = "+state+"]";
    }
}