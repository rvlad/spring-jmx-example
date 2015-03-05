package com.naevatec.monitor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

import com.naevatec.monitor.bean.KmsSgaMember;
import com.naevatec.monitor.bean.SgaMember;
import com.naevatec.monitor.bean.SgaType;
import com.naevatec.monitor.dss.DssMonitorService;
import com.naevatec.monitor.dss.KmsMonitorService;

@Component
@ManagedResource(objectName = "monitor:type=sga", description = "SGA Monitor Info")
public class DesktopScreenSharingJmxExtension implements
		Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private DssMonitorService dssMonitorService;

	@Autowired
	private KmsMonitorService kmsMonitorService;

	@ManagedOperation(description = "Obtain image-ids by instance type")
	public List<String> getIdsByType(
			@ManagedOperationParameter(name = "type", description = "SGA type") String type) {
		SgaType sType = SgaType.findByName(type);
		List<String> ids = new ArrayList<String>();
		List<? extends SgaMember> members;
		switch (sType) {
		case DSS:
			members = dssMonitorService.getMembers();
			break;
		case KMS:
			members = kmsMonitorService.getMembers();
			break;
		case WOWZA:
			// TODO implement
		default:
			throw new RuntimeException("Unsupported SGA type: " + type);
		}
		for (SgaMember sm : members)
			ids.add(sm.getImageId());
		return ids;
	}

	@ManagedOperation(description = "Obtain instance type status")
	public String getStatusByType(
			@ManagedOperationParameter(name = "type", description = "SGA type") String type) {
		SgaType sType = SgaType.findByName(type);
		switch (sType) {
		case DSS:
			return dssMonitorService.getDssStatus().toString();
		case KMS:
			return kmsMonitorService.getKmsStatus().toString();
		case WOWZA:
			// TODO implement
		default:
			throw new RuntimeException("Unsupported SGA type: " + type);
		}
	}

	@ManagedOperation(description = "Obtain instance's status by type and image-id")
	public String getStatusByInstanceIdAndType(
			@ManagedOperationParameter(name = "type", description = "SGA type") String type,
			@ManagedOperationParameter(name = "id", description = "image-id") String imgId) {
		List<? extends SgaMember> members = getSgaMembersByType(type);
		for (SgaMember s : members)
			if (s.getImageId().equalsIgnoreCase(imgId))
				return s.getStatus().toString();
		throw new RuntimeException("Not found");
	}

	@ManagedOperation(description = "Obtain instance's CPU by type and image-id")
	public Double getCpuByInstanceIdAndType(
			@ManagedOperationParameter(name = "type", description = "SGA type") String type,
			@ManagedOperationParameter(name = "id", description = "image-id") String imgId) {
		List<? extends SgaMember> members = getSgaMembersByType(type);
		for (SgaMember s : members)
			if (s.getImageId().equalsIgnoreCase(imgId))
				return s.getCpu();
		throw new RuntimeException("Not found");
	}

	@ManagedOperation(description = "Obtain instance's MEM by type and image-id")
	public Integer getMemoryByInstanceIdAndType(
			@ManagedOperationParameter(name = "type", description = "SGA type") String type,
			@ManagedOperationParameter(name = "id", description = "image-id") String imgId) {
		List<? extends SgaMember> members = getSgaMembersByType(type);
		for (SgaMember s : members)
			if (s.getImageId().equalsIgnoreCase(imgId))
				return s.getMemory();
		throw new RuntimeException("Not found");
	}

	@ManagedOperation(description = "Obtain instance's USAGE by type and image-id")
	public Double getUsageByInstanceIdAndType(
			@ManagedOperationParameter(name = "type", description = "SGA type") String type,
			@ManagedOperationParameter(name = "id", description = "image-id") String imgId) {
		SgaType sType = SgaType.findByName(type);
		if (sType.compareTo(SgaType.KMS) != 0)
			throw new RuntimeException("Attribute not supported");
		List<? extends SgaMember> members = getSgaMembersByType(type);
		for (SgaMember s : members)
			if (s.getImageId().equalsIgnoreCase(imgId))
				return ((KmsSgaMember) s).getUsage();
		throw new RuntimeException("Not found");
	}

	@ManagedOperation(description = "Obtain instance's CONNECTIONS by type and image-id")
	public Integer getConnectionsByInstanceIdAndType(
			@ManagedOperationParameter(name = "type", description = "SGA type") String type,
			@ManagedOperationParameter(name = "id", description = "image-id") String imgId) {
		SgaType sType = SgaType.findByName(type);
		if (sType.compareTo(SgaType.WOWZA) != 0)
			throw new RuntimeException("Attribute not supported");
		throw new RuntimeException("Not implemented yet...");
		// TODO
		// List<? extends SgaMember> members = getSgaMembersByType(type);
		// for (SgaMember s : members)
		// if (s.getImageId().equalsIgnoreCase(imgId))
		// return ((WowzaSgaMember)s).getConnections();
		// throw new RuntimeException("Not found");
	}

	private List<? extends SgaMember> getSgaMembersByType(String type) {
		SgaType sType = SgaType.findByName(type);
		List<? extends SgaMember> members;
		switch (sType) {
		case DSS:
			members = dssMonitorService.getMembers();
			break;
		case KMS:
			members = kmsMonitorService.getMembers();
			break;
		case WOWZA:
			// TODO implement
		default:
			throw new RuntimeException("Unsupported SGA type: " + type);
		}
		return members;
	}

	@ManagedAttribute(description = "Sgas.")
	public String getSgasString() {
		try {
			return buildSgas().toString();
		} catch (Exception e) {
		}
		return null;
	}

	@ManagedOperation(description = "Sga by name.")
	public String findSgaByNameString(String type) {
		SgaType sType = SgaType.findByName(type);
		switch (sType) {
		case DSS:
			return dssMonitorService.getSga().toString();
		case KMS:
			return kmsMonitorService.getSga().toString();
		case WOWZA:
			// TODO implement
		default:
			throw new RuntimeException("Unsupported SGA type: " + type);
		}
	}

	@ManagedOperation(description = "Sga members list by name.")
	public String findSgaMemberListByNameString(String type) {
		SgaType sType = SgaType.findByName(type);
		switch (sType) {
		case DSS:
			return dssMonitorService.getMembers().toString();
		case KMS:
			return kmsMonitorService.getMembers().toString();
		case WOWZA:
			// TODO implement
		default:
			throw new RuntimeException("Unsupported SGA type: " + type);
		}
	}

	@ManagedOperation(description = "Sga member by sga-name and member image-id.")
	public String findSgaMemberByNameAndImageIdString(String type,
			String imageId) {
		try {
			List<? extends SgaMember> members = getSgaMembersByType(type);
			for (SgaMember s : members)
				if (s.getImageId().equalsIgnoreCase(imageId))
					return s.toString();
		} catch (Exception e) {
		}
		return null;
	}

	private SgaAggregate buildSgas() {
		SgaAggregate sgasAgg = new SgaAggregate();
		sgasAgg.setDss(dssMonitorService.getSga());
		sgasAgg.setKms(kmsMonitorService.getSga());
		// TODO Wowza
		return sgasAgg;
	}
}
