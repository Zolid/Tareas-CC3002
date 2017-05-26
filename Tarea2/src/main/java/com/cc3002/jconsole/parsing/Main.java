package com.cc3002.jconsole.parsing;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.beust.jcommander.converters.IParameterSplitter;
import com.cc3002.jconsole.data.BarData;
import com.cc3002.jconsole.data.IProcesingData;
import com.cc3002.jconsole.data.ScatterData;
import com.cc3002.jconsole.plot.BarPlot;
import com.cc3002.jconsole.plot.IGraphPlot;
import com.cc3002.jconsole.plot.ScatterPlot;



/**
 * La Clase Main esta encargada de realizar el parsing
 * para los datos ingresados por linea de comandos, y responder
 * el ploteo correspondiente de cada tipo de grafico para los 
 * datos ingresados.
 */
public class Main {
	
	/**
	 * The Class NonSplittingSpliter.
	 */
	private static final class NonSplittingSpliter implements IParameterSplitter {
        
        /* (non-Javadoc)
         * @see com.beust.jcommander.converters.IParameterSplitter#split(java.lang.String)
         */
        public List<String> split(String value) {
            return Collections.singletonList(value);
        }
    }
	
	/** El tipo de grafico. */
	@Parameter(description="graphs")
	private static List<String> graph;

	/** Comando para el path de un archivo. */
	@Parameter(names={"-F"}, help=true)
	private String path ="";
	
	/** Lista para almacenar las tuplas de datos. */
	@Parameter(names={"-P"},splitter = NonSplittingSpliter.class, variableArity = true)
	private List<String> tuples = Collections.emptyList();
	
	/** Comando para acotar los datos del eje X */
	@Parameter(names={"-x"})
	int x = 0;
	
	/** Comando para acotar los datos del eje Y. */
	@Parameter(names={"-y"})
	int y = 0;
	

	/**
	 * The main method.
	 *
	 * @param argv the arguments
	 * @throws ParameterException the parameter exception
	 * @throws FileNotFoundException the file not found exception
	 */
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
			//System.out.println("Datos mal ingresados!!!");
		}
		
	}

	/**
	 * Metodo bar para plotear un grafico tipo BarPlot, cuando
	 * se ingresa el comando BarPlot.
	 */
	public void bar() {
		IProcesingData data = new BarData();
		if (!tuples.isEmpty()) {
			if (x != 0) {
				System.out.println("Las categorías no son números, por tanto, no se pueden acotar");
			}
			else if (y != 0) {
				IGraphPlot g = new BarPlot(data, tuples);
				g.acotateY(y);
				System.out.println(g.plot());
			} else {
				IGraphPlot g = new BarPlot(data, tuples);
				System.out.println(g.plot());
			}
		}
		else if(!path.equals("")) {
			if (x != 0) {
				System.out.println("Las categorías no son números, por tanto, no se pueden acotar");
			}
			else if (y != 0) {
				IGraphPlot g = new BarPlot(data, path);
				g.acotateY(y);
				System.out.println(g.plot());
			} else {
				IGraphPlot g = new BarPlot(data, path);
				System.out.println(g.plot());
			}
		} else {
			System.out.println("Solo están permitidos los comandos BarPlot o ScatterPlot.");
		}
	}
	
	/**
	 * Metodo scatter para plotear un grafico tipo ScatterPlot, cuando
	 * se ingresa el comando ScatterPlot.
	 */
	public void scatter() {
		IProcesingData data = new ScatterData();
		if (!tuples.isEmpty()) {
			if (x != 0) {
				IGraphPlot g = new ScatterPlot(data, tuples);
				g.acotateX(x);
				System.out.println(g.plot());
			}
			else if (y != 0) {
				IGraphPlot g = new ScatterPlot(data, tuples);
				g.acotateY(y);
				System.out.println(g.plot());
			}
			else if (x != 0 && y != 0) {
				IGraphPlot g = new ScatterPlot(data, tuples);
				g.acotateXY(x, y);
				System.out.println(g.plot());
			} else {
				IGraphPlot g = new ScatterPlot(data, tuples);
				System.out.println(g.plot());
			}
			
		}
		else if(!path.equals("")) {
			if (x != 0) {
				IGraphPlot g = new ScatterPlot(data, path);
				g.acotateX(x);
				System.out.println(g.plot());
			}
			else if (y != 0) {
				IGraphPlot g = new ScatterPlot(data, path);
				g.acotateY(y);
				System.out.println(g.plot());
			}
			else if (x != 0 && y != 0) {
				IGraphPlot g = new ScatterPlot(data, path);
				g.acotateXY(x, y);
				System.out.println(g.plot());
			} else {
				IGraphPlot g = new ScatterPlot(data, path);
				System.out.println(g.plot());
			}
		} else {
			System.out.println("Solo están permitidos los comandos BarPlot o ScatterPlot.");
		}
	}



}
