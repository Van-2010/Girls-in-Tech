package com.init.GirlsInTeck.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.GirlsInTeck.dto.PointDto;
import com.init.GirlsInTeck.entity.Point;
import com.init.GirlsInTeck.repository.LocationRepository;
import com.init.GirlsInTeck.repository.PointRepository;


@Service
public class ServicePoint {
	
	@Autowired
	private PointRepository pointRepository ;
	
	@Autowired
	private com.init.GirlsInTeck.repository.DirectionRepository DirectionRepository;
	
	@Autowired
	private LocationRepository locationRepository;

	// 1 List  points
	
		public List<Point> listPoints() {
			List<Point> points;
			points = pointRepository.findAll();
			return points;
		}

		// 2 create point
		public Point createPoint(PointDto pointDto) {
			Point point=new Point();
			
				point.setActivity(point.getActivity());
				point.setColor(point.getColor());
				point.setAddress(point.getAddress());
				point.setLocation(point.getLocation());
				point.setName(point.getName());
				point.setWhy(point.getWhy());
				point.setRadio(point.getRadio());
				point.setVerified(point.isVerified());
				point.setWhy(pointDto.getWhy());
				point.setRadio(pointDto.getRadio());
				point.setVerified(pointDto.isVerified());
				pointRepository.save(point);
			
			return point;
		}

		// 3 delete point
		public String deletePointById(int id) {
			String response;
			Optional<Point> point = pointRepository.findById(id);
			
			if (!point.isEmpty()) {
				Point pointForDelete=point.get();
				pointRepository.delete(pointForDelete);
				response = "deleted point";
			} else {
				response = "this point doesn't exixst";
			}
			return response;
		}

		// 4 saerch point

		public String getPointById(int id) {

			String response;
			Optional<Point> OptionalPoint = pointRepository.findById(id);
			if (!OptionalPoint.isEmpty()) {
				Point pointForGet=OptionalPoint.get();
				
				response = pointForGet.toString();
			} else {
				response = "this point doesn't exixst";
			}
			return response;

		}

		// 5 update point
		public String updatePoint(int id, PointDto PointDto) {
			String response;
			Optional<Point> Optionalpoint = pointRepository.findById(id);
			if (!Optionalpoint.isEmpty()) {
				Point updatepoint = Optionalpoint.get();
				updatepoint.setActivity(PointDto.getActivity());
				updatepoint.setColor(PointDto.getColor());
				updatepoint.setAddress(PointDto.getAddress());
				updatepoint.setLocation(PointDto.getLocation());
				updatepoint.setName(PointDto.getName());
				updatepoint.setWhy(PointDto.getWhy());
				updatepoint.setRadio(PointDto.getRadio());
				updatepoint.setVerified(PointDto.isVerified());
				
				pointRepository.save(updatepoint);
				response = "this point has been modified";
			} else {
				response = "this point doesn't exist";
			}
			return response;
		}
}