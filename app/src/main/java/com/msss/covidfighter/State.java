package com.msss.covidfighter;




public class State
{
    private String total;

    private String death;

    private String cured;

    private String name;

    private String active;

    private String _id;

    public String getTotal ()
    {
        return total;
    }

    public void setTotal (String total)
    {
        this.total = total;
    }

    public String getDeath ()
    {
        return death;
    }

    public void setDeath (String death)
    {
        this.death = death;
    }

    public String getCured ()
    {
        return cured;
    }

    public void setCured (String cured)
    {
        this.cured = cured;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getActive ()
    {
        return active;
    }

    public void setActive (String active)
    {
        this.active = active;
    }

    public String get_id ()
    {
        return _id;
    }

    public void set_id (String _id)
    {
        this._id = _id;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [total = "+total+", death = "+death+", cured = "+cured+", name = "+name+", active = "+active+", _id = "+_id+"]";
    }
}
