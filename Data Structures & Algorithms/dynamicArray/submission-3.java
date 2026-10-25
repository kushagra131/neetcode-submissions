class DynamicArray {
    private int[] array;
    private int length;
    private int capacity;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
        this.length = 0;
    }

    public int get(int i) {
        return array[i];
    }

    public void set(int i, int n) {
        array[i] = n;

    }

    public void pushback(int n) {
        if(length == capacity)
            resize();
        
        array[length] = n; 
        length++;
    }

    public int popback() {
        int element = array[length - 1];
        length--;
        return element;
    }

    private void resize() {
        capacity = capacity * 2;
        int[] temp_array = new int[capacity];
        for(int i = 0; i < array.length; i++)
            temp_array[i] = array[i];
        
        array = temp_array;
        temp_array = null;
    }

    public int getSize() {
        return length;
    }

    public int getCapacity() {
        return capacity;
    }
}
