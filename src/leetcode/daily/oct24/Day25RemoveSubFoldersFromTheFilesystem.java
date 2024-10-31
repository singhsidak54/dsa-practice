package daily.oct24;

import java.util.ArrayList;
import java.util.List;

public class Day25RemoveSubFoldersFromTheFilesystem {
    class Node {
        Node[] child;
        boolean isFolder;
        public Node() {
            this.child = new Node[27];
        }
    }

    class Trie {
        Node root;
        public Trie() {
            this.root = new Node();
        }

        public void add(String folder) {
            Node curr = this.root;
            int index = 0;
            while (index < folder.length()) {
                char c = folder.charAt(index);
                int nIndex = c == '/' ? 26 : c - 'a';
                if(curr.child[nIndex] == null) {
                    curr.child[nIndex] = new Node();
                }

                curr = curr.child[nIndex];
                index++;
            }

            curr.child[26] = new Node();
            curr = curr.child[26];
            curr.isFolder = true;
        }

        public void getTopFolders(Node curr, StringBuilder str, List<String> res) {
            if(curr.isFolder) {
                res.add(str.substring(0, str.length() - 1));
                return;
            }

            for(int i=0; i<27; i++) {
                if(curr.child[i] == null) continue;
                char c = i == 26 ? '/' : (char) ('a' + i);
                str.append(c);
                getTopFolders(curr.child[i], str, res);
                str.deleteCharAt(str.length() - 1);
            }
        }
    }

    public List<String> removeSubfolders(String[] folders) {
        Trie trie = new Trie();
        for(String folder : folders) {
            trie.add(folder);
        }

        List<String> ans = new ArrayList<>();
        trie.getTopFolders(trie.root, new StringBuilder(), ans);
        return ans;
    }

    public static void main(String[] args) {
        String[] folders = {"/a","/a/b","/c/d/","/c/d/e","/c/f"};
        Day25RemoveSubFoldersFromTheFilesystem obj = new Day25RemoveSubFoldersFromTheFilesystem();
        System.out.println(obj.removeSubfolders(folders));
    }
}
