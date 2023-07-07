package main.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import main.entities.Room;
import main.entities.RoomType;
import main.exceptions.NotFoundException;
import main.payloads.RoomPayload;
import main.repositories.RoomRepository;
import main.repositories.RoomTypeRepository;

@Service
public class RoomService {

	@Autowired
	private RoomRepository roomRepository;

	@Autowired
	private RoomTypeRepository roomTypeRepository;

	public Page<Room> find(int page, int size, String sortBy) {
		if (size < 0)
			size = 10;
		if (size > 100)
			size = 100;
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

		return roomRepository.findAll(pageable);
	}

	public Room create(RoomPayload body) {
		RoomType roomType = new RoomType(body.getRoomType().getName(), body.getRoomType().getInitials(),
				body.getRoomType().getDescription(), body.getRoomType().getPrice(), body.getRoomType().getCapacity());
		roomTypeRepository.save(roomType);
		Room room = new Room(body.getRoomNumber(), body.getFloor(), body.getRoomStatus(), body.isSmoking(), roomType);
		return roomRepository.save(room);
	}

	public Room findById(UUID id) throws NotFoundException {
		return roomRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("ATTENZIONE!!! L'ospite cercato non è stato trovato!"));
	}

	public Room findByIdAndUpdate(UUID id, RoomPayload body) throws NotFoundException {
		Room found = this.findById(id);

		found.setRoomId(id);
		found.setRoomNumber(body.getRoomNumber());
		found.setFloor(body.getFloor());
		found.setRoomStatus(body.getRoomStatus());
		found.setSmoking(body.isSmoking());
//		found.setRoomType(body.get()); DA CONTROLLARE

		return roomRepository.save(found);
	}

	public void findByIdAndDelete(UUID id) throws NotFoundException {
		Room found = this.findById(id);
		roomRepository.delete(found);
	}

}