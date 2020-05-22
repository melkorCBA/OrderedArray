package ordarrayapp;

public class OrdArray {

    private long[] a;
    private int nElems = 0;
    private int lowIndex=0;

    public OrdArray(int max) {

        a = new long[max + 1];
    }

    public int size() {
        return nElems;
    }

    public int find(long searchKey) {
        int findReturn;
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int currentIndex = 0;

        do {

            currentIndex = (lowerBound + upperBound) / 2;

            if (searchKey == a[currentIndex]) {
                findReturn = currentIndex;
                break;
            } else {
                if (lowerBound > upperBound) {
                    findReturn = this.size();
                    break;
                } else {

                    if (a[currentIndex] < searchKey) {
                        lowerBound = currentIndex + 1;
                    } else {
                        upperBound = currentIndex - 1;
                    }
                }

            }
        } while (true);

        return findReturn;

    }

    public int findRecursive(long key, int lowerBound, int upperBound, int currentIndex) {
        if (nElems == 0) {
            return a.length;
        }
        if (a[currentIndex] == key) {
            return currentIndex;

        }
        if (lowerBound > upperBound) {
            return size();
        }
        if (a[currentIndex] > key) {
            currentIndex = (lowerBound + upperBound) / 2;
            return findRecursive(key, lowerBound, upperBound - 1, currentIndex);

        } else {
            currentIndex = (lowerBound + upperBound) / 2;
            return findRecursive(key, lowerBound + 1, upperBound, currentIndex);

        }

    }

    public void insert(long value) {
        int middleIndex = 0;

        if (nElems == 0) {
            a[0] = value;
            nElems = nElems + 1;
        } else {
            if (value > a[nElems - 1]) {
                a[nElems] = value;
                nElems = nElems + 1;
            } else {
                if (value < a[0]) {
                    for (int i = nElems; i < 0; i--) {
                        a[i] = a[i - 1];
                    }
                    a[0] = value;
                    nElems = nElems + 1;

                } else {
                    for (int i = 0; i < nElems; i++) {
                        if (a[i] < value && a[i + 1] > value) {
                            middleIndex = i + 1;
                            break;
                        }
                    }

                    for (int j = nElems; j > middleIndex; j--) {
                        a[j] = a[j - 1];

                    }
                    a[middleIndex] = value;
                    nElems = nElems + 1;

                }

            }
        }

    }

    public void insertRecursive(long key, int currentIndex) {
        if (size() == 0) {
            a[0] = key;
            nElems = nElems + 1;
        } else if (a[currentIndex] == 0) {
            a[currentIndex] = key;
        } else if (a[currentIndex] > key) {
            insertRECHelp(key, currentIndex, nElems - 1);

        } else {
            insertRecursive(key, currentIndex + 1);
        }

    }

    public void insertRECHelp(long key, int currentIndex, int altIndex) {
        if (currentIndex == altIndex) {
            a[currentIndex] = key;
            nElems = nElems + 1;
        } else {
            a[altIndex + 1] = a[altIndex];
            insertRECHelp(key, currentIndex, altIndex - 1);
        }

    }

    public boolean delete(long value) {
        boolean returnIteam;
        int findIndex = this.find(value);
        if (findIndex != a.length) {
            nElems = nElems - 1;
            for (int i = findIndex; i < nElems; i++) {
                a[i] = a[i + 1];
            }
            returnIteam = true;
        } else {
            returnIteam = false;
        }

        return returnIteam;

    }

    public void display() {

        for (int i = 0; i < nElems; i++) {
            System.out.print(a[i] + ", ");
        }

    }

}
