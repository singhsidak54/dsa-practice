package daily.misc;

public class ReadNCharactersGivenRead4II {
    int read4(char[] buf4) { return 0; }

    int currentBufferRead = 0;
    int currentBufferCapacity = 0;
    char[] buf4 = new char[4];
    public int read(char[] buf, int n) {
        int i = 0;
        while (currentBufferRead<currentBufferCapacity && i<n) {
            buf[i++] = buf4[currentBufferRead++];
        }

        if(currentBufferRead < currentBufferCapacity) return i;

        while (i < n) {
            currentBufferRead = 0;
            currentBufferCapacity = read4(buf4);
            if(currentBufferCapacity == 0) return i;
            while (currentBufferRead<currentBufferCapacity && i<n) {
                buf[i++] = buf4[currentBufferRead++];
            }
        }

        return i;
    }
}
