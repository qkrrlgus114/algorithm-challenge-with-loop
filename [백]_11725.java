import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N;
    static List<Integer>[] list;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        list = new List[N + 1];
        result = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];

        for (int i = 0; i < N - 1; i++) {
            String[] sa = bf.readLine().split(" ");
            int start = Integer.parseInt(sa[0]);
            int end = Integer.parseInt(sa[1]);

            // 양쪽 다 넣어야 한다.
            list[start].add(end);
            list[end].add(start);
        }

        visited[1] = true;
        dfs(1);

        for (int i = 2; i < N + 1; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb.toString());

    }

    public static void dfs(int idx) {

        for (int i = 0; i < list[idx].size(); i++) {
            int next = list[idx].get(i);

            if (visited[next]) continue;

            visited[next] = true;
            result[next] = idx;
            dfs(next);
        }
    }


}
