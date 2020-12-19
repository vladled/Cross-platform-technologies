package lab03.fileReader;


import  java.io.IOException;
import  java.nio.file.Files;
import  java.nio.file.Paths;
import  java.util.Collections;
import  java.util.List;
import  java.util.stream.Collectors;
import  java.util.stream.Stream;


public  class  FileReader  { private  String  filePath;

    public  FileReader(final  String  filePath)  { this.filePath  =  filePath;
    }

    public  List<Integer>  readAsIntegers()  throws  IOException  {
        try  (final  Stream<String>  stream  =  Files.lines(Paths.get(filePath)))  { return  stream.flatMap(line  ->  line.chars()
                .mapToObj(character  ->  character))
                .collect(Collectors.toList());
        }  catch  (IOException  e)  { e.printStackTrace();
            return  Collections.emptyList();
        }
    }
    public  String  getFilePath()  { return  filePath;
    }

    public  void  setFilePath(final  String  filePath)  { this.filePath  =  filePath;
    }

}
