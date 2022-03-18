class SNode<T>
{
    /* properties */
    public T key;
    public T value;
    public SNode<T> frontNode = null;
    public SNode<T> backNode = null;

    /* constructors */
    public SNode() { } 
    public SNode(T key){this.key = key;}
    public SNode(T key, T value)
    {
        this.key = key;
        this.value = value; 
    }

    /* methods */
    public T getKey() { return this.key; }
    public T getValue() { return this.value; }
    public void setKey(T key) { this.key = key; }
    public void setValue(T val) { this.value = val; }
}
