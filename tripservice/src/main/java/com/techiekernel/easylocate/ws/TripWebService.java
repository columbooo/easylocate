package com.techiekernel.easylocate.ws;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.techiekernel.easylocate.pojo.Trip;
import com.techiekernel.easylocate.service.TripService;

@Controller
@RequestMapping("/api/trip")
public class TripWebService {

	@Autowired
	TripService tripService;

	@RequestMapping(value = "/{tripId}", method = RequestMethod.GET, headers = "Accept=application/json", produces = { "application/json" })
	@ResponseBody
	public Trip getTrip(@PathVariable int tripId, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return tripService.getTrip(tripId);
	}

	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json", produces = { "application/json" })
	@ResponseBody
	public List<Trip> getTrips(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return tripService.getTrips();
	}

	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json", produces = { "application/json" }, consumes = { "application/json" })
	@ResponseBody
	public boolean createTrip(@RequestBody Trip trip,
			HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return tripService.saveOrUpdateTrip(trip);
	}

	@RequestMapping(value = "/{tripId}", method = RequestMethod.PUT, headers = "Accept=application/json", produces = { "application/json" }, consumes = { "application/json" })
	@ResponseBody
	public boolean editFoobar(@RequestBody Trip trip, @PathVariable int tripId,
			HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		if (trip.getTripId() != null)
			return tripService.saveOrUpdateTrip(trip);
		else
			return false;
	}

	@RequestMapping(value = "/{tripId}", method = RequestMethod.DELETE, headers = "Accept=application/json", produces = { "application/json" })
	@ResponseBody
	public boolean deleteTrip(@PathVariable int tripId,
			HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		return tripService.deleteTrip(tripId);
	}

}
