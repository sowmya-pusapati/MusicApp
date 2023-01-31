import java.util.*;

public class Main {
    public static List<Album> albums=new ArrayList<>();
    public static void main(String[] args) {

        Album album1=new Album("peace","sid");
        album1.addSongToAlbum("kanulu",5.5);
        album1.addSongToAlbum("gala",4.08);
        album1.addSongToAlbum("fun",5.5);

        Album album2=new Album("summer","DSP");
        album2.addSongToAlbum("pushpa",4.09);
        album2.addSongToAlbum("chupe",3.04);
        album2.addSongToAlbum("enduko",6.00);

        albums.add(album1);
        albums.add(album2);
        System.out.println(album1.findSong("chupe"));

        LinkedList<Song> myPlaylist = new LinkedList<>();
        album1.addToPlaylistFromAlbum("kanulu",myPlaylist);
        album1.addToPlaylistFromAlbum("fun",myPlaylist);
        album2.addToPlaylistFromAlbum(1,myPlaylist);
        album2.addToPlaylistFromAlbum("chupe",myPlaylist);

        play(myPlaylist);

    }
     public static void printMenu()
     {
         System.out.println("1-Play next song");
         System.out.println("2-Play previous song");
         System.out.println("3-Repeat the current song");
         System.out.println("4-Show menu agian");
         System.out.println("5-Delete the current song");
         System.out.println("6-Show all songs");
         System.out.println("7-Exit");
         return;
     }

    public static void play(LinkedList<Song> playList)
    {
        ListIterator<Song> itr=playList.listIterator();
        Scanner sc=new Scanner(System.in);

        boolean isForward=false;
        if(playList.size()>0)
        {
            System.out.print("currently playing: ");
            System.out.println(itr.next());
            isForward=true;
        }
        else {
            System.out.println("playlist is empty");
            return;
        }
        System.out.println("Enter your choice");
        printMenu();
        boolean quit=false;
        while(!quit)
        {
            int choice=sc.nextInt();
            switch(choice)
            {

                case 1:
                    if(isForward==false)
                    {
                        itr.next();
                        isForward=true;

                    }
                    if(itr.hasNext())
                    {
                        System.out.println(itr.next());
                    }
                    else {
                        System.out.println("you are at the end of list");
                    }
                    break;
                 case 2:
                     if(isForward==true)
                     {
                         itr.previous();
                         isForward=false;
                     }
                     if(itr.hasPrevious())
                     {
                         System.out.println(itr.previous());
                     }
                     else {
                         System.out.println("you are at start of the list");
                     }
                     break;
                case 3:
                    if(isForward==true){
                        if(itr.hasPrevious())
                        {
                            System.out.println(itr.previous());
                            isForward=false;
                        }
                    }
                    else {
                        if(itr.hasNext())
                        {
                            System.out.println(itr.next());
                            isForward=true;
                        }
                    }
                    break;
                case 4:
                    printMenu();
                    break;
                case 5:
                    if(isForward==true){
                    if(itr.hasPrevious())
                    {
                        System.out.println("deleted successfully"+itr.previous());
                        itr.remove();
                        isForward=false;
                    }
                }
                else {
                    if(itr.hasNext())
                    {
                        System.out.println("deleted successfully"+itr.next());
                        itr.remove();
                        isForward=true;
                    }
                }
                    break;
                case 6:
                    printSongs(playList);
                    break;
                case 7:
                    quit=true;
                    break;

            }
        }

    }
    public static void printSongs(LinkedList<Song> playList)
    {
        for(Song song:playList)
        {
            System.out.println(song);
        }
        return;
    }
}