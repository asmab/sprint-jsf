package edu.asma.mawalni;

import javax.annotation.PostConstruct;


import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

import edu.esprit.entities.Project;
import edu.esprit.services.project.ProjectServiceLocal;


@ManagedBean
public class ChartViewSale implements Serializable {
	@EJB
	private ProjectServiceLocal csl;

	private List<Project> listProjects;

	public List<Project> getListProjects() {
		return listProjects;
	}

	public void setListProjects(List<Project> listProjects) {
		this.listProjects = listProjects;
	}

	private PieChartModel pieModel1;
    private BarChartModel barchart;
	public void setPieModel1(PieChartModel pieModel1) {
		this.pieModel1 = pieModel1;
	}

	@PostConstruct
	public void init() {
		createPieModels();
		createBarModels();
	}


	public PieChartModel getPieModel1() {
		return pieModel1;
	}



	private void createPieModels() {
		createPieModel1();
	}
	private void createBarModels() {
		createBarModel1();
	}
	private BarChartModel createBarModel1() {
		barchart = new BarChartModel();

        ChartSeries boys = new ChartSeries();
        boys.setLabel("Boys");
        boys.set("Tunis", csl
				.findEventByPlace("Tunis")
				.size());
        boys.set("Sousse", csl
				.findEventByPlace("Sousse")
				.size());
        boys.set("Hammamet", csl
				.findEventByPlace("Hammamet")
				.size());
   

        barchart.addSeries(boys);
         
        return barchart;
	}
	

	private void createPieModel1() {
		pieModel1 = new PieChartModel();

		pieModel1.set("Musique", csl
				.findProjectByCategorie("Musique")
				.size());
		pieModel1.set("Informatique", csl
				.findProjectByCategorie("Informatique")
				.size());
		
		pieModel1.set("Technologie", csl
				.findProjectByCategorie("Technologie")
				.size());
		pieModel1.set("Bureau", csl
				.findProjectByCategorie("Bureau")
				.size());
		pieModel1.setTitle("Project Per Category");
		pieModel1.setLegendPosition("w");
	}

	public BarChartModel getBarchart() {
		return barchart;
	}

	public void setBarchart(BarChartModel barchart) {
		this.barchart = barchart;
	}

	

	
}