package Tess;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
 
import org.eclipse.jgit.api.AddCommand;
import org.eclipse.jgit.api.CommitCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.InitCommand;
import org.eclipse.jgit.api.ReflogCommand;
import org.eclipse.jgit.api.errors.ConcurrentRefUpdateException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.NoMessageException;
import org.eclipse.jgit.api.errors.UnmergedPathsException;
import org.eclipse.jgit.api.errors.WrongRepositoryStateException;
import org.eclipse.jgit.errors.UnmergedPathException;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.storage.file.ReflogEntry;
 
public class testprog
{
  public static void main(String[] args) throws Exception
  {
    File gitWorkDir = new File("/home/abdullatasleem/Downloads/gittest");
    Git git = null;
 
    InitCommand initCommand = Git.init();
    initCommand.setDirectory(gitWorkDir);
    git = initCommand.call();
 
    git = Git.open(gitWorkDir); // not necessary, but show how to open an existing repo
     
    changeContentAndCommit(git, "DoubleCloud.org rocks!", "first commit");
    changeContentAndCommit(git, "DoubleCloud.org really rocks!", "second commit");
    changeContentAndCommit(git, "DoubleCloud.org really really rocks!", "third commit");
     
    Iterator<RevCommit> iterator = git.log().call().iterator();
 
    RevCommit rc2 = iterator.next();
    System.out.println("msg2:" + rc2.getFullMessage());
    System.out.println("con2:" + new String(rc2.getRawBuffer()));
    System.out.println("msg1:" + iterator.next().getFullMessage());
     
    ReflogCommand reflogCmd = git.reflog();
    Collection<ReflogEntry> reflogs = reflogCmd.call();
    System.out.println("size of reflogs:" + reflogs.size());
  }
 
  private static void changeContentAndCommit(Git git, String content, String message) throws NoHeadException, NoMessageException, UnmergedPathsException, ConcurrentRefUpdateException, WrongRepositoryStateException, GitAPIException, UnmergedPathException, JGitInternalException
  {
    File workDir = git.getRepository().getWorkTree();
    File myfile = new File(workDir, "file1.txt");
    writeToFile(myfile, content);
 
    AddCommand add = git.add();
    add.addFilepattern(".").call();
 
    CommitCommand commit = git.commit();
    commit.setMessage(message).call();
  }
 
 
  public static void writeToFile(File file, String text)
  {
    FileWriter writer;
    try
    {
        writer = new FileWriter(file);
        writer.write(text);
        writer.close();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
//package Tess;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class testprog {
//    public static void main(String args[]) {
//        String s;
//        Process p;
//        try {
//            p = Runtime.getRuntime().exec("ls -aF");
//            BufferedReader br = new BufferedReader(
//                new InputStreamReader(p.getInputStream()));
//            while ((s = br.readLine()) != null)
//                System.out.println("line: " + s);
//            p.waitFor();
//            System.out.println ("exit: " + p.exitValue());
//            p.destroy();
//        } catch (Exception e) {}
//    }
//}