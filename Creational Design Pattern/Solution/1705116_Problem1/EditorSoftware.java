package com.company.Mai;

import java.io.*;

interface Parser
{
    String getSelectedParser();
}

class CParser implements Parser
{
    private final String CParsing;
    CParser()
    {
        CParsing="Selected Parser for C";
    }

    @Override
    public String getSelectedParser() {
        return CParsing;
    }
}

class CPPParser implements Parser
{

    private final String CPPParsing;
    CPPParser()
    {
        CPPParsing="Selected Parser for CPP";
    }

    @Override
    public String getSelectedParser() {
        return CPPParsing;
    }
}

class PYTHONParser implements Parser
{
    private final String PythonParsing;
    PYTHONParser()
    {
        PythonParsing="Selected Parser for Python";
    }

    @Override
    public String getSelectedParser() {
        return PythonParsing;
    }
}

interface Aesthetics
{

    String style="Normal";
    String color="Blue";

    String getFont();
}

class CAesthetics implements Aesthetics
{
    private final String fontname;
    CAesthetics()
    {
        fontname="Courier New";
    }
    @Override
    public String getFont() {
        return fontname;
    }
}


class CPPAesthetics implements Aesthetics
{
    private final String fontname;
    CPPAesthetics()
    {
        fontname=" Monaco";
    }
    @Override
    public String getFont() {
        return fontname;
    }
}

class PYTHONAesthetics implements Aesthetics
{
    private final String fontname;
    PYTHONAesthetics()
    {
        fontname="Consolas";
    }
    @Override
    public String getFont() {
        return fontname;
    }
}

abstract class AbstractFactory
{
    public abstract Parser getParser(String language);
    public abstract Aesthetics getAesthetics(String language);
}

class ParserFactory extends AbstractFactory
{
    @Override
    public Parser getParser(String language)
    {
        if(language==null)
        {
            return null;

        }
        if(language.equalsIgnoreCase(".c"))
        {
            return new CParser();
        }
        else if(language.equalsIgnoreCase(".cpp"))
        {
            return new CPPParser();
        }
        else if(language.equalsIgnoreCase(".py"))
        {
            return new PYTHONParser();
        }
        return null;
    }

    @Override
    public Aesthetics getAesthetics(String language) {
        return null;
    }
}

class AestheticsFactory extends AbstractFactory
{
    @Override
    public Parser getParser(String language) {
        return null;
    }

    @Override
    public Aesthetics getAesthetics(String language) {
        if(language==null)
        {
            return null;
        }
        else if(language.equalsIgnoreCase(".c"))
        {
            return new CAesthetics();

        }
        else if(language.equalsIgnoreCase(".cpp"))
        {
            return new CPPAesthetics();
        }
        else if(language.equalsIgnoreCase(".py"))
        {
            return new PYTHONAesthetics();
        }
        return  null;
    }
}

class FactoryCreator
{
    public static AbstractFactory getFactory(String choice)
    {
        if(choice.equalsIgnoreCase("Parser"))
        {
            return new ParserFactory();
        }
        else if(choice.equalsIgnoreCase("Aesthetics"))
        {
            return new AestheticsFactory();
        }
        return null;
    }
}
class Editor
{

    private  static Editor editor=new Editor();
    private Editor()
    {


    }

    public static Editor getInstance() {
        return editor;
    }

    void OpenEditor(String language)
    {

        AbstractFactory parserFactory=FactoryCreator.getFactory("Parser");
        Parser p=parserFactory.getParser(language);
        System.out.println(p.getSelectedParser());

        System.out.print("Font Name : ");
        AbstractFactory aestheticsFactory=FactoryCreator.getFactory("Aesthetics");
        Aesthetics a=aestheticsFactory.getAesthetics(language);
        System.out.println(a.getFont());


    }




}
public class EditorSoftware {
    public static void main(String args[]) throws IOException
    {
        Editor editor=Editor.getInstance();
        while (true)
        {
            System.out.println();
            System.out.println("Choice input file extention(.c,.cpp,.py): ");
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String language=br.readLine();



            editor.OpenEditor(language);
        }




    }




}
