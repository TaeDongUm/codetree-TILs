import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        LinkedList<Message> meg = new LinkedList<>();
        LinkedList<String> read = new LinkedList<>();

        // 입력값 받기
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            meg.add(new Message(st.nextToken(), Integer.parseInt(st.nextToken())));
        }

        // 확인이 필요한 메시지 번호 p
        String pPerson = meg.get(p-1).person;
        int dontRead = meg.get(p-1).dontReadPerson;

        // p 메시지 이후 사람은 p 메시지를 읽었으므로
        // p 메시지 이후 사람을 포함한다.
        for(int i=p-1;i<meg.size();i++){
            String person = meg.get(i).person;
            if(!isContain(read, person)) read.add(person);
        }

        // 읽지 않은 사람의 수가 같을 경우 고려해야 한다.
        for(int i=0;i<meg.size();i++){
            int tmpNum = meg.get(i).dontReadPerson;
            String tmpPerson = meg.get(i).person;

            if(dontRead == tmpNum){
                if(!isContain(read, tmpPerson)) read.add(tmpPerson);
            }
        }
        Collections.sort(read);
        int[] checkPerson = new int[n];
        int[] idxPerson = new int[n];
        checkPerson = readPerson(read, n);
        combination(checkPerson, dontRead, 0, 0, idxPerson);
    }
    public static void combination(int[] checkPerson, int dontRead, int idx, int count, int[] idxPerson){
        if(count == dontRead){
            for(int i=0;i<idxPerson.length;i++){
                if(idxPerson[i] ==1){
                    char answer = (char)(i + 65);
                    System.out.print(answer);
                }
            }
            System.out.print(" ");
            return;
        }
        for(int i=idx;i<checkPerson.length;i++){
            if(checkPerson[i]==1) continue;
            idxPerson[i] =1;
            combination(checkPerson, dontRead, i+1, count+1, idxPerson);
            idxPerson[i] =0;
        }
    }
    public static boolean isContain(LinkedList<String> list, String person){
        for(int i=0;i<list.size();i++){
            if(list.get(i).equals(person)) return true;
        }
        return false;
    }

    public static int[] readPerson(LinkedList<String> read, int n){
        int[] tmp = new int[n];
        for(int i=0;i<read.size();i++){
            int idx = read.get(i).charAt(0) - 65;
            tmp[idx] = 1;
        }
        return tmp;
    }

}
class Message{
    String person;
    int dontReadPerson;

    public Message(String person, int dontReadPerson){
        this.person = person;
        this.dontReadPerson = dontReadPerson;
    }

}