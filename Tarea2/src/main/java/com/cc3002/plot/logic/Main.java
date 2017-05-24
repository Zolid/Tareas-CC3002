package com.cc3002.plot.logic;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.beust.jcommander.converters.IParameterSplitter;


public class Main {
	
	private static final class NonSplittingSpliter implements IParameterSplitter {
        public List<String> split(String value) {
            return Collections.singletonList(value);
        }
    }
	
	@Parameter(description="graphs")
	private static List<String> graph;

	@Parameter(names={"-F"}, help=true)
	private String path ="";
	
	@Parameter(names={"-P"},splitter = NonSplittingSpliter.class, variableArity = true)
	private List<String> tuples = Collections.emptyList();
	

	public static void main(String ... argv) throws ParameterException, FileNotFoundException  {
		try {
			Main main = new Main();
			JCommander.newBuilder()
			.addObject(main)
			.build()
			.parse(argv);
			if (graph.get(0).equals("BarPlot")) {
				main.bar();
			}
			else if (graph.get(0).equals("ScatterPlot")) {
				main.scatter();
			}
		} catch (com.beust.jcommander.ParameterException e) {
			System.out.println("Recuerde ingresar los valores correctos:");
			System.out.println("Por ejemplo:");
			System.out.println("BarPlot -F ruta/del/los/datos");
			System.out.println("ScatterPlot -P 3,2 4,5 7,9");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Datos mal ingresados!!!");
		}
		
	}

	public void bar() {
		if (!tuples.isEmpty()) {
			IProcesingData data = new BarData();
			Graph g = new BarPlot(data, tuples);
			System.out.println(g.plot());
		}
		else if(!path.equals("")) {
			IProcesingData data = new BarData();
			Graph g = new BarPlot(data, path);
			System.out.println(g.plot());
		} else {
			System.out.println("Solo están permitidos los comandos BarPlot o ScatterPlot.");
		}
		System.out.println(graph.toString());
		System.out.println(tuples.isEmpty());
		System.out.println(path);
	}
	
	public void scatter() {
		if (!tuples.isEmpty()) {
			IProcesingData data = new ScatterData();
			Graph g = new ScatterPlot(data, tuples);
			System.out.println(g.plot());
		}
		else if(!path.equals("")) {
			IProcesingData data = new ScatterData();
			Graph g = new ScatterPlot(data, path);
			System.out.println(g.plot());
		} else {
			System.out.println("Solo están permitidos los comandos BarPlot o ScatterPlot.");
		}
	}



}
