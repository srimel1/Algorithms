import java.util.*;

public class DA_AccountMerge {
    public static void main(String[] args) {
        DA_AccountMerge am = new DA_AccountMerge();
        List<List<String>> accounts = new ArrayList<List<String>>();
        List<String> account = new ArrayList<>();
        account.add("John");
        account.add("johnsmith@mail.com");
        account.add("john00@mail.com");
        accounts.add(account);
        account = new ArrayList<>();
        account.add("John");
        account.add("johnnybravo@mail.com");
        accounts.add(account);
        account = new ArrayList<>();
        account.add("John");
        account.add("johnsmith@mail.com");
        account.add("john_newyork@mail.com");
        accounts.add(account);
        account = new ArrayList<>();
        account.add("Mary");
        account.add("mary@mail.com");
        accounts.add(account);
        List<List<String>> ans = am.accountsMerge(accounts);
        for (List<String> acc : ans) {
            System.out.println(Arrays.toString(acc.toArray()));
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emails = new HashMap<>();
        Map<String, String> emailOwners = new HashMap<>();
        int emailId = 0;
        UF3 uf = new UF3(10001);
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                // save the name
                // key: johnsmith@mail.com
                // value: John
                if (!emailOwners.containsKey(account.get(i))) {
                    emailOwners.put(account.get(i), account.get(0));
                }
                // map email to emailId
                // key: johnsmith@mail.com
// value: emailId (1,2,...)
                if (!emails.containsKey(account.get(i))) {
                    emails.put(account.get(i), emailId + i);
                }
// merge the emails from this account
                uf.union(emailId + 1, emails.get(account.get(i)));
            }
            emailId += account.size() - 1;
        }
        // search for the graph to collect all emails
        Map<Integer, TreeSet<String>> emailGroup = new HashMap<>();
        Set<String> visited = new HashSet<>();
        List<List<String>> ans = new ArrayList<>();
        for (String email : emails.keySet()) {
            if (visited.contains(email)) continue;
            visited.add(email);
            int parent = uf.find(emails.get(email));
            TreeSet<String> members = null;
            if (emailGroup.containsKey(parent) == false) {
                members = new TreeSet<>();
            } else members = emailGroup.get(parent);
            members.add(email);
            emailGroup.put(parent, members);
        }
        for (TreeSet<String> emailList : emailGroup.values()) {
            String owner = null;
            List<String> acct = new ArrayList<>();
            for (String email : emailList) {
                if (owner == null) {
                    owner = emailOwners.get(email);
                    acct.add(owner);
                }
                acct.add(email);
            }
            ans.add(acct);
        }
        return ans;
    }
}

class UF3 {
    private int[] parent, rank;

    public UF3(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    public void union(int x, int y) {
        int xRoot = find(x), yRoot = find(y);
        if(xRoot == yRoot) return;

        if(rank[xRoot] < rank[yRoot])
            parent[xRoot] = yRoot;

        else if(rank[yRoot] < rank[xRoot])
            parent[yRoot] = xRoot;

        else{
            parent[yRoot] = xRoot;
            rank[xRoot] = rank[xRoot] + 1;
        }
        parent[find(y)] = find(x);
    }

    public int find(int x) {
        if (parent[x] == x) return x;
        return find(parent[x]);
    }
}